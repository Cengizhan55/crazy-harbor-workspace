package com.crazycoder.crazyharborbff.domain.data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "EVENT_HISTORY")
@Getter
@Setter
public class EventHistoryEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 3676584738031712381L;
    @Id
    @Column(name = "GUID", updatable = false, nullable = false)
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String guid;

    @Column(name = "APPLICATION_NAME")
    private String applicationName;

    @Column(name = "EVENT_NAME")
    private String eventName;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "CREATE_DATE")
    @CreatedDate
    private LocalDateTime createDate;

}
