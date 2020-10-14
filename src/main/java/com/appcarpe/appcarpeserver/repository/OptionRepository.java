package com.appcarpe.appcarpeserver.repository;

import com.appcarpe.appcarpeserver.entity.Option;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OptionRepository extends JpaRepository<Option,Integer> {
}
