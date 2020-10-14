package com.appcarpe.appcarpeserver.repository;

import com.appcarpe.appcarpeserver.entity.Lieu;
import com.appcarpe.appcarpeserver.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface LieuRepository extends JpaRepository<Lieu, Integer> {
    Set<Lieu> findAllByUser(User user);
}
