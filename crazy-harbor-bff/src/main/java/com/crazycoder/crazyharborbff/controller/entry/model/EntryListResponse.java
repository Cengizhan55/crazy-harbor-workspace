package com.crazycoder.crazyharborbff.controller.entry.model;


import com.crazycoder.crazyharborbff.domain.data.entity.EntryEntity;
import lombok.Data;

import java.util.List;

@Data
public class EntryListResponse {
   private List<EntryEntity> entryList;
}
