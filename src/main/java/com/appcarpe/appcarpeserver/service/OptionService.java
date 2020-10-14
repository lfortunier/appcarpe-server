package com.appcarpe.appcarpeserver.service;

import com.appcarpe.appcarpeserver.entity.Option;
import com.appcarpe.appcarpeserver.entity.user.User;
import com.appcarpe.appcarpeserver.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class OptionService {

    private final UserService userService;
    private final UserRepository userRepository;

    public OptionService(UserService userService,
                         UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }

    public Option getOptionByUserId(Integer userId) throws Exception {
        if (userId != null) {
            User user = userService.getUser(userId);
            if (user != null && user.getOptionEntity() != null) {
                return user.getOptionEntity();
            } else {
                Option option = new Option();
                option.setShareLieu(false);
                User u = userService.getUser(userId);
                u.setOptionEntity(option);
                userRepository.save(u);
                return userRepository.save(u).getOptionEntity();
            }
        }
        throw new Exception("L'user avec l'id : " + userId + " n'existe pas");
    }
}
