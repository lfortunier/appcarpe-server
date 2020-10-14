package com.appcarpe.appcarpeserver.controller;

import com.appcarpe.appcarpeserver.repository.SituationGeographiqueRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/situation_geographique")
public class SituationGeographiqueController {

    private final SituationGeographiqueRepository situationGeographiqueRepository;

    public SituationGeographiqueController(SituationGeographiqueRepository situationGeographiqueRepository) {
        this.situationGeographiqueRepository = situationGeographiqueRepository;
    }

//    @GetMapping("")
//    public ResponseEntity<?> getSituationGeographique(){
//        return ResponseEntity.ok(situationGeographiqueRepository.findAll());
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<?> getSituationGeographique(@NotNull @PathVariable Integer id){
//        Optional<SituationGeographique> optionalSituationGeographique = situationGeographiqueRepository.findById(id);
//        if (optionalSituationGeographique.isPresent()){
//            return ResponseEntity.ok(optionalSituationGeographique.get());
//        }
//        return ResponseEntity.notFound().build();
//    }
//
//    @PostMapping("/edit")
//    public ResponseEntity<?> createOrUpdateSituationGeographique(@NotNull @RequestBody SituationGeographique situationGeographique){
//            return ResponseEntity.ok(situationGeographiqueRepository.save(situationGeographique));
//    }
}
