package com.appcarpe.appcarpeserver.controller;

import com.appcarpe.appcarpeserver.entity.Lieu;
import com.appcarpe.appcarpeserver.repository.LieuRepository;
import com.appcarpe.appcarpeserver.service.LieuService;
import com.sun.istack.NotNull;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/lieu")
public class LieuController {

    private final LieuRepository lieuRepository;
    private final LieuService lieuService;

    @Autowired
    public LieuController(LieuRepository lieuRepository,
                          LieuService lieuService){
        this.lieuRepository = lieuRepository;
        this.lieuService = lieuService;
    }

    @GetMapping(value = "")
    public ResponseEntity<?> getLieux() throws Exception {
        return ResponseEntity.ok(lieuService.getUserLieux());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getLieu(@NotNull @PathVariable(value = "id") Integer lieuId) throws NotFoundException {
        Optional<Lieu> lieuOptional = lieuRepository.findById(lieuId);
        if (lieuOptional.isPresent()){
            return ResponseEntity.ok(lieuOptional.get());
        }
        throw new NotFoundException("Le lieu avec l'id "+ lieuId +" n'existe pas");
    }

    @PostMapping(value = "/edit")
    public ResponseEntity<?> createOrUpdateLieu(@NotNull @RequestBody Lieu lieu) throws Exception {
        return ResponseEntity.ok(lieuService.createOrUpdateLieu(lieu));
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<?> deleteLieu(@NotNull @PathVariable(value = "id") Integer lieuId) throws Exception {
        lieuRepository.deleteById(lieuId);
        return ResponseEntity.ok().build();
    }
}
