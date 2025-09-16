package com.crazycoder.crazyharborbff.domain.service.entry;

import com.crazycoder.crazyharborbff.controller.entry.model.EntryListResponse;
import com.crazycoder.crazyharborbff.controller.entry.model.EntryRequest;

public interface EntryService {
    EntryListResponse getAllEntries();

    void saveEntry(String text);

    void clearOldOnes();

    void updateEntry(EntryRequest id);
}
