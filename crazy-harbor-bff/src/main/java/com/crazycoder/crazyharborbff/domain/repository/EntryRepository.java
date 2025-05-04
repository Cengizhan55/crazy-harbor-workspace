package com.crazycoder.crazyharborbff.domain.repository;

import com.crazycoder.crazyharborbff.domain.data.entity.EntryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public interface EntryRepository extends JpaRepository<EntryEntity, Long> {

    @Modifying
    @Transactional
    @Query("DELETE FROM EntryEntity e WHERE e.id IN (SELECT e2.id FROM EntryEntity e2 ORDER BY e2.createDate ASC LIMIT 50)")
    void deleteLast50Entries();
}
