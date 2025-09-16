package com.crazycoder.crazyharborbff.controller.entry;


import com.crazycoder.crazyharborbff.controller.common.BaseController;
import com.crazycoder.crazyharborbff.controller.entry.model.EntryListResponse;
import com.crazycoder.crazyharborbff.controller.entry.model.EntryRequest;
import com.crazycoder.crazyharborbff.domain.service.entry.impl.EntryServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@RequestMapping("/entry/v1")
@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class EntryController implements BaseController {


    private final EntryServiceImpl entryService;

    public EntryController(EntryServiceImpl entryService) {
        this.entryService = entryService;
    }


    @PostMapping
    public boolean saveEntry(@RequestBody EntryRequest request) {

        entryService.saveEntry(request.getText());

        return true;

    }

    @GetMapping
    public EntryListResponse getEntryList() {

        EntryListResponse allEntries = entryService.getAllEntries();

        if (allEntries.getEntryList().size() >= 100) {
            entryService.clearOldOnes();
        }

        return allEntries;
    }

    @PostMapping("/update")
    public ResponseEntity<Boolean> updateEntity(@RequestBody EntryRequest request) {

        entryService.updateEntry(request);

        return ResponseEntity.ok(true);

    }

}
