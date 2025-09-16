package com.crazycoder.crazyharborbff.domain.data.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Table(name = "ENTRY")
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public class EntryEntity {

    @Id
    @Column(name = "ID", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQUENCE_ENTRY")
    @SequenceGenerator(name = "SEQUENCE_ENTRY", sequenceName = "SEQUENCE_ENTRY", allocationSize = 1)
    private Long id;

    @Column(name = "ENTRY_OWNER_ID")
    private Long entryOwnerId;

    @Column(name = "ENTRY_WRITING")
    private String entryWriting;


    @CreatedDate
    private LocalDateTime createDate;

    @CreatedBy
    private String createdBy;

    @LastModifiedDate
    private LocalDateTime lastModifiedDate;


    @LastModifiedBy
    private String lastModifiedBy;





}
