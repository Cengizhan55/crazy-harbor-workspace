package com.crazycoder.crazyharborbff.domain.service.entry.impl;

import com.crazycoder.crazyharborbff.controller.entry.model.EntryListResponse;
import com.crazycoder.crazyharborbff.domain.data.entity.EntryEntity;
import com.crazycoder.crazyharborbff.domain.repository.EntryRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(MockitoExtension.class)
class EntryServiceImplTest {

    @InjectMocks
    EntryServiceImpl entryService;

    @Mock
    EntryRepository repository;


    @Test
    void getAllEntries() {

        EntryEntity entity = new EntryEntity();

        Mockito.when(repository.findAll()).thenReturn(List.of(entity));

        EntryListResponse allEntries = entryService.getAllEntries();

        assertEquals(allEntries.getEntryList().size(), 1);
    }

    @Test
    void saveEntry() {
    }

    @Test
    void clearOldOnes() {
    }
}