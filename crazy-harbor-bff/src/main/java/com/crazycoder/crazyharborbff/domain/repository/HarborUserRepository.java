package com.crazycoder.crazyharborbff.domain.repository;


import com.crazycoder.crazyharborbff.domain.data.entity.HarborUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HarborUserRepository extends JpaRepository<HarborUserEntity,Long> {
    Optional<HarborUserEntity> findByUsername(String username);

    boolean existsByUsername(String username);

}
