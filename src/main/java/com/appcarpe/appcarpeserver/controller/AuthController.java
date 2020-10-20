package com.appcarpe.appcarpeserver.controller;

import com.appcarpe.appcarpeserver.configuration.security.SecurityConstants;
import com.appcarpe.appcarpeserver.entity.user.User;
import com.appcarpe.appcarpeserver.error.ApiError;
import com.appcarpe.appcarpeserver.error.ApiErrorException;
import com.appcarpe.appcarpeserver.repository.UserRepository;
import com.appcarpe.appcarpeserver.service.AuthService;
import com.sun.istack.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

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
    public ResponseEntity<?> login() {
        // SpringSecurity manage this route
        return ResponseEntity.ok().build();
    }

    @PostMapping("/refresh-token")
    public ResponseEntity<User> refreshToken(HttpServletRequest request){
        String token = request.getHeader(SecurityConstants.HEADER_STRING);
        String userEmail  = AuthService.getUserEmailByToken(token);
        if (userEmail != null){
            Optional<User> user = userRepository.findByEmail(userEmail);
            if (user.isPresent()){
                return ResponseEntity.ok(user.get());
            }
        }
        return ResponseEntity.ok().build();
    }
}
