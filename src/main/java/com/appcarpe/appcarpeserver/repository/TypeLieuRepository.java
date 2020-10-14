package com.appcarpe.appcarpeserver.repository;

import com.appcarpe.appcarpeserver.entity.type_lieu.TypeLieu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeLieuRepository extends JpaRepository<TypeLieu,Integer> {
}
