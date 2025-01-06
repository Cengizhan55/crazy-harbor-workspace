package com.crazycoder.crazyharborbff.domain.service.entry.impl;


import com.crazycoder.crazyharborbff.controller.entry.model.EntryListResponse;
import com.crazycoder.crazyharborbff.domain.data.entity.EntryEntity;
import com.crazycoder.crazyharborbff.domain.repository.EntryRepository;
import com.crazycoder.crazyharborbff.domain.service.entry.EntryService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class EntryServiceImpl implements EntryService {

    private final EntryRepository entryRepository;

    public EntryServiceImpl(EntryRepository entryRepository) {
        this.entryRepository = entryRepository;
    }


    @Override
    public EntryListResponse getAllEntries() {

        List<EntryEntity> all = entryRepository.findAll();

        EntryListResponse response = new EntryListResponse();
        response.setEntryList(all);

        return response;
    }

    @Override
    public void saveEntry(String text) {
        EntryEntity entity = new EntryEntity();
        entity.setEntryWriting(text);


        entryRepository.save(entity);
    }

    @Override
    public void clearOldOnes() {
        entryRepository.deleteLast50Entries();
    }

}
