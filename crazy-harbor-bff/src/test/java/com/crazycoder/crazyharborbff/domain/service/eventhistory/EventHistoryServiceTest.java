package com.crazycoder.crazyharborbff.domain.service.eventhistory;

import com.crazycoder.crazyharborbff.config.application.ApplicationProperties;
import com.crazycoder.crazyharborbff.domain.data.entity.EventHistoryEntity;
import com.crazycoder.crazyharborbff.domain.repository.EventHistoryRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.crazycoder.crazyharborbff.TestUtils.EventHistoryServiceUtil.DEFAULT_APP_NAME;
import static com.crazycoder.crazyharborbff.TestUtils.EventHistoryServiceUtil.DEFAULT_GUID;
import static com.crazycoder.crazyharborbff.TestUtils.EventHistoryServiceUtil.getEventHistoryDto;
import static com.crazycoder.crazyharborbff.TestUtils.EventHistoryServiceUtil.getEventHistoryEntity;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class EventHistoryServiceTest {

    @InjectMocks
    EventHistoryService eventHistoryService;

    @Mock
    EventHistoryRepository eventHistoryRepository;

    @Mock
    ApplicationProperties applicationProperties;

    @Test
    @DisplayName("when creating an entity should return same guid ")
    void createEventHistory() {

        EventHistoryEntity eventHistoryEntity = getEventHistoryEntity();

        when(eventHistoryRepository.save(any())).
                thenReturn(eventHistoryEntity);

        when(applicationProperties.getName()).thenReturn(DEFAULT_APP_NAME);

        String eventHistory = eventHistoryService.createEventHistory(getEventHistoryDto());

        Assertions.assertEquals(eventHistory, DEFAULT_GUID);
    }
}