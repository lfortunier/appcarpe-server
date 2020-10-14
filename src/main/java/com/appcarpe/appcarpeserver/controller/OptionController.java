package com.appcarpe.appcarpeserver.controller;

import com.appcarpe.appcarpeserver.repository.OptionRepository;
import com.appcarpe.appcarpeserver.service.OptionService;
import com.appcarpe.appcarpeserver.service.UserService;
import org.springframework.stereotype.Controller;

@Controller
public class OptionController {

    private final OptionRepository optionRepository;
    private final OptionService optionService;
    private final UserService userService;

    public OptionController(OptionRepository optionRepository,
                            OptionService optionService,
                            UserService userService) {
        this.optionRepository = optionRepository;
        this.optionService = optionService;
        this.userService = userService;
    }

//    @GetMapping("/option/{optionId}")
//    public ResponseEntity<?> getOption(@PathVariable Integer optionId) {
//        Optional<Option> optionOptional = optionRepository.findById(optionId);
//        if (optionOptional.isPresent()) {
//            return ResponseEntity.ok(optionOptional.get());
//        }
//        return ResponseEntity.notFound().build();
//    }
//
//    @GetMapping("/option/user/{userId}")
//    public ResponseEntity<?> getOptionByUserId(@PathVariable Integer userId) throws Exception {
//        if (userId != null) {
//            userService.checkUser(userId);
//            Option option = optionService.getOptionByUserId(userId);
//            return ResponseEntity.ok(option);
//        }
//        return ResponseEntity.notFound().build();
//    }
//
//    @PostMapping("/option/edit")
//    public ResponseEntity<?> createOrUpdateOption(@RequestBody Option option){
//        return ResponseEntity.ok(optionRepository.save(option));
//    }
}
