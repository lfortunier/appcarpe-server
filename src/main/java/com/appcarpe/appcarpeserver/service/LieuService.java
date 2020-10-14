package com.appcarpe.appcarpeserver.service;

import com.appcarpe.appcarpeserver.entity.Lieu;
import com.appcarpe.appcarpeserver.entity.SituationGeographique;
import com.appcarpe.appcarpeserver.repository.LieuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class LieuService {

    private final LieuRepository lieuRepository;
    private final UserService userService;
    private final SituationGeographiqueService situationGeographiqueService;

    @Autowired
    public LieuService(LieuRepository lieuRepository,
                       UserService userService,
                       SituationGeographiqueService situationGeographiqueService) {
        this.lieuRepository = lieuRepository;
        this.userService = userService;
        this.situationGeographiqueService = situationGeographiqueService;
    }

    public Set<Lieu> getUserLieux() throws Exception {
        return lieuRepository.findAllByUser(userService.getCurrentUser());
    }

    public Lieu createOrUpdateLieu(Lieu lieu) throws Exception {
        if (lieu != null) {
            SituationGeographique situationGeographique = situationGeographiqueService.getSituationGeographique(lieu.getSituationGeographique());
            lieu.setSituationGeographique(situationGeographique);
            lieu.setUser(userService.getCurrentUser());
            return lieuRepository.save(lieu);
        }
        return null;
    }
}
