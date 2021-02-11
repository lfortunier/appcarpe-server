package com.appcarpe.appcarpeserver.repository;

import com.appcarpe.appcarpeserver.entity.SituationGeographique;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SituationGeographiqueRepository extends JpaRepository<SituationGeographique, Integer> {
    Optional<SituationGeographique> findByCodePostalAndNomVilleAndDepartement(String codePostal, String nomVille, String departement);
}
