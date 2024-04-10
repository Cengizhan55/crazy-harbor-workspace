package com.crazycoder.crazyharborbff.domain.repository;

import com.crazycoder.crazyharborbff.domain.data.entity.EventHistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventHistoryRepository extends JpaRepository<EventHistoryEntity,String> {
}
