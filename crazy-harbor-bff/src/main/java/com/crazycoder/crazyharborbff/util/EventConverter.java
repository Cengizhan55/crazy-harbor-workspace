package com.crazycoder.crazyharborbff.util;

import com.crazycoder.crazyharborbff.domain.data.entity.HarborUserEntity;
import com.crazycoder.crazyharborbff.domain.service.publisher.model.EventHistoryDTO;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class EventConverter {


    public EventHistoryDTO convertToEventHistoryDTO(HarborUserEntity entity) {

        EventHistoryDTO dto = new EventHistoryDTO();

        dto.setGuid("1");
        dto.setApplicationName("crazy-harbor-bff");
        dto.setEventName("HarborUserCreation");
        dto.setCreateDate(LocalDateTime.now().toString() );
        dto.setDescription("User has been created with given credentials: "
                + " --id: " + entity.getId().toString()
                + " --name: " + entity.getFirstName()
                + " --lastName: " + entity.getLastName()
                + " --createDate: " + LocalDateTime.now());

        return dto;
    }

}
