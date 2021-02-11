package com.appcarpe.appcarpeserver.service;

import com.appcarpe.appcarpeserver.entity.SituationGeographique;
import com.appcarpe.appcarpeserver.repository.SituationGeographiqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SituationGeographiqueService {

    private final SituationGeographiqueRepository situationGeographiqueRepository;

    @Autowired
    public SituationGeographiqueService(SituationGeographiqueRepository situationGeographiqueRepository) {
        this.situationGeographiqueRepository = situationGeographiqueRepository;
    }

    public SituationGeographique getSituationGeographique(SituationGeographique situationGeographique) {
        SituationGeographique sGResult = null;
        if (situationGeographique != null) {
            Optional<SituationGeographique> sGBodySearch = situationGeographiqueRepository.findByCodePostalAndNomVilleAndDepartement(situationGeographique.getCodePostal(), situationGeographique.getNomVille(), situationGeographique.getDepartement());
            if (sGBodySearch.isPresent()){
                sGResult = sGBodySearch.get();
            }else {
                situationGeographique.setId(null);
                sGResult = situationGeographique;
            }
        }
        return sGResult;
    }
}
