package com.crazycoder.crazyharborbff.domain.data.entity;


import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "HEALTH_CHECK")
public class HealthCheckEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = -5838779944426149032L;
    @Id
    @Column(name = "GUID", updatable = false, nullable = false)
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String guid;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DATA")
    private String data;

}
