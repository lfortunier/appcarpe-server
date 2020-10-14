package com.appcarpe.appcarpeserver.controller;

import com.appcarpe.appcarpeserver.entity.user.User;
import com.appcarpe.appcarpeserver.repository.UserRepository;
import com.appcarpe.appcarpeserver.service.UserService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.constraints.NotNull;
import java.util.Optional;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserRepository userRepository;
    private final UserService userService;

    @Autowired
    public UserController(UserRepository userRepository,
                          UserService userService) {
        this.userRepository = userRepository;
        this.userService = userService;
    }

    @GetMapping(value = "")
    public ResponseEntity<?> getCurrentUser() throws Exception {
        return ResponseEntity.ok(userService.getCurrentUser());
    }

    @PatchMapping(value = "/edit")
    public ResponseEntity<?> modifyUser(@RequestBody @NotNull User user) throws NotFoundException {
        Optional<User> userOptional = userRepository.findById(user.getId());
        if (userOptional.isEmpty()){
            throw new NotFoundException("L'usager avec l'id "+ user.getId()+ " n'existe pas");
        }
        user.setPassword(userOptional.get().getPassword());
        return ResponseEntity.ok(userRepository.save(user));
    }
}
