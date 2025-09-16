package com.crazycoder.crazyharborbff.domain.service.entry.impl;


import com.crazycoder.crazyharborbff.controller.entry.model.EntryListResponse;
import com.crazycoder.crazyharborbff.controller.entry.model.EntryRequest;
import com.crazycoder.crazyharborbff.domain.data.entity.EntryEntity;
import com.crazycoder.crazyharborbff.domain.repository.EntryRepository;
import com.crazycoder.crazyharborbff.domain.service.entry.EntryService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

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

        try {
            EntryEntity entity = new EntryEntity();
            entity.setEntryWriting(text);

            entryRepository.save(entity);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }

    }

    @Override
    public void updateEntry(EntryRequest request) {

        try {
            Optional<EntryEntity> entityOptional = entryRepository.findById(Long.valueOf(request.getId()));
            EntryEntity entity = entityOptional.get();


            entity.setEntryWriting(request.getText());

            entryRepository.save(entity);

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }

    }

    @Override
    public void clearOldOnes() {
        entryRepository.deleteLast50Entries();
    }

}
