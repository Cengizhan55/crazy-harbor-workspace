package com.crazycoder.crazyharborbff.domain.repository;

import com.crazycoder.crazyharborbff.domain.data.entity.ParameterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ParameterRepository extends JpaRepository<ParameterEntity,Long> {

}
