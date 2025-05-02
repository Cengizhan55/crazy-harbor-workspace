package com.crazycoder.crazyharborbff.domain.service.publisher.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serial;

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
