package com.appcarpe.appcarpeserver.controller;

import com.appcarpe.appcarpeserver.entity.user.User;
import com.appcarpe.appcarpeserver.error.ApiError;
import com.appcarpe.appcarpeserver.error.ApiErrorException;
import com.appcarpe.appcarpeserver.repository.UserRepository;
import com.sun.istack.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/auth")
public class AuthController {

    private final UserRepository userRepository;

    public AuthController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@NotNull @RequestBody User user) throws ApiErrorException {
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        if (userRepository.existsUserByEmail(user.getEmail())){
            ApiError apiError = new ApiError();
            apiError.setStatus(HttpStatus.CONFLICT);
            apiError.setErrors("L'utilisateur avec l'email : " + user.getEmail() + " existe déja");
            throw new ApiErrorException(apiError);
        }
        return ResponseEntity.ok(userRepository.save(user));
    }

    @PostMapping("/login")
    public ResponseEntity<User> login() {
        // SpringSecurity manage this route
        return ResponseEntity.ok().build();
    }
}
