package com.appcarpe.appcarpeserver.service;

import com.appcarpe.appcarpeserver.entity.user.User;
import com.appcarpe.appcarpeserver.repository.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void checkUser(Integer id) throws Exception {
        if (id != null && !userRepository.existsById(id)) {
            throw new Exception("L'user avec l'id : " + id + "n'existe pas");
        }
    }

    public User getUser(Integer id) throws Exception {
        if (id != null) {
            Optional<User> userOptional = userRepository.findById(id);
            if (userOptional.isPresent()) {
                return userOptional.get();
            }
        }
        throw new Exception("L'user avec l'id : " + id + "n'existe pas");
    }

    public User getCurrentUser() throws Exception {
        Optional<User> currentUserOpt = userRepository.findByEmail((String)SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        if (currentUserOpt.isPresent()){
            return currentUserOpt.get();
        }
        throw new Exception("Il n'y a pas d'utilisateur de connecté");
    }
}
