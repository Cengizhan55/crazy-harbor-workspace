package com.crazycoder.crazyharborbff.domain.service.publisher.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
public class EventHistoryDTO {
    public EventHistoryDTO(String guid, String applicationName, String eventName, String description, String createDate) {
        this.guid = guid;
        this.applicationName = applicationName;
        this.eventName = eventName;
        this.description = description;
        this.createDate = createDate;
    }

    public EventHistoryDTO() {
    }

    @Serial
    private static final long serialVersionUID = 1L;

    private String guid;

    private String applicationName;

    private String eventName;

    private String description;

    private String createDate;
}
