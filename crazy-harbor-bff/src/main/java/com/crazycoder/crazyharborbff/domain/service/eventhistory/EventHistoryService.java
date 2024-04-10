package com.crazycoder.crazyharborbff.domain.service.eventhistory;


import com.crazycoder.crazyharborbff.config.application.ApplicationProperties;
import com.crazycoder.crazyharborbff.domain.data.entity.EventHistoryEntity;
import com.crazycoder.crazyharborbff.domain.repository.EventHistoryRepository;
import com.crazycoder.crazyharborbff.domain.service.publisher.model.EventHistoryDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Slf4j
@EnableConfigurationProperties(ApplicationProperties.class)
public class EventHistoryService {


    private final ApplicationProperties applicationProperties;

    private final EventHistoryRepository repository;

    public EventHistoryService(ApplicationProperties applicationProperties, EventHistoryRepository repository) {
        this.applicationProperties = applicationProperties;
        this.repository = repository;
    }

    public String createEventHistory(EventHistoryDTO eventHistoryDTO) {

        try {
            EventHistoryEntity entity = new EventHistoryEntity();
            entity.setApplicationName(applicationProperties.getName());
            entity.setEventName(eventHistoryDTO.getEventName());
            entity.setDescription(eventHistoryDTO.getDescription());
            entity.setCreateDate(LocalDateTime.now());
            EventHistoryEntity savedEntity = repository.save(entity);
            return savedEntity.getGuid();
        } catch (RuntimeException e) {
            log.error("Exception while creating a eventHistory. Exception -> " + e);
            throw new RuntimeException(e.getMessage());
        }
    }
}
