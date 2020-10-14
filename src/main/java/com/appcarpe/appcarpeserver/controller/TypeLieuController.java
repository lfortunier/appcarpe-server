package com.appcarpe.appcarpeserver.controller;

import com.appcarpe.appcarpeserver.repository.TypeLieuRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/type_lieu")
public class TypeLieuController {

    private final TypeLieuRepository typeLieuRepository;

    public TypeLieuController(TypeLieuRepository typeLieuRepository){
        this.typeLieuRepository = typeLieuRepository;
    }

    @GetMapping("")
    public ResponseEntity<?> getTypesLieu(){
        return ResponseEntity.ok(typeLieuRepository.findAll());
    }
}
