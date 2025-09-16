package com.crazycoder.crazyharborbff.TestUtils;

import com.crazycoder.crazyharborbff.domain.data.entity.EventHistoryEntity;
import com.crazycoder.crazyharborbff.domain.service.publisher.model.EventHistoryDTO;

import java.time.LocalDateTime;

public final class EventHistoryServiceUtil {


    public static final String DEFAULT_APP_NAME = "CRAZY-HARBOR-BFF";
    public static final String DEFAULT_GUID = "asdasd-asdasd-asdas";


    public static EventHistoryEntity getEventHistoryEntity() {

        EventHistoryEntity entity = new EventHistoryEntity();

        entity.setEventName("myEventName");
        entity.setDescription("myDescription");
        entity.setCreateDate(LocalDateTime.now());
        entity.setGuid(DEFAULT_GUID);
        entity.setEventName("myEventName");
        entity.setApplicationName(DEFAULT_APP_NAME);
        return entity;
    }

    public static EventHistoryDTO getEventHistoryDto() {

        EventHistoryDTO entity = new EventHistoryDTO();
        entity.setEventName("myEventName");
        entity.setDescription("myDescription");
        entity.setGuid(DEFAULT_GUID);
        entity.setEventName("myEventName");
        entity.setApplicationName(DEFAULT_APP_NAME);
        return entity;
    }
}
