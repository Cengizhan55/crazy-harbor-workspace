package com.crazycoder.crazyharborbff.domain.data.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name ="PARAMETER")
public class ParameterEntity {

    @Id
    @Column(name = "ID",nullable = false,updatable = false)
    private Long id;

    @Column(name = "APPLICATION_NAME")
    private String applicationName;

    @Column(name = "KEY")
    private String key;

    @Column(name = "VALUE")
    private String value;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
