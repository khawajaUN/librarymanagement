package com.begoassingment.librarymanagement.repository;

import com.begoassingment.librarymanagement.model.LibraryItem;
import com.begoassingment.librarymanagement.model.ItemType;

import java.util.List;

public interface LibraryItemRepository {
    void save(LibraryItem item);

    List<LibraryItem> getAllItems();

    List<LibraryItem> getItemsByType(ItemType type);

    LibraryItem getItemByUniqueID(Long uniqueID);
}

