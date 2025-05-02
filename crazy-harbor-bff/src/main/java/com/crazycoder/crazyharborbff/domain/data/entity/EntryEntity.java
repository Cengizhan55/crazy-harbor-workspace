package com.crazycoder.crazyharborbff.domain.data.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
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

    @Column(name = "CREATE_DATE")
    @CreatedDate
    private LocalDateTime createDate;

}
