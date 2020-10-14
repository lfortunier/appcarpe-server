package com.appcarpe.appcarpeserver;

import com.appcarpe.appcarpeserver.entity.user.User;
import com.appcarpe.appcarpeserver.repository.LieuRepository;
import com.appcarpe.appcarpeserver.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Optional;

@Component
public class AppInitializator {

    @Autowired
    private LieuRepository lieuRepository;

    @Autowired
    private UserRepository userRepository;


    @PostConstruct
    private void init() {
//        Optional<User> user = userRepository.findByEmail("aaaa");
//        System.err.println(user);
    }
}
