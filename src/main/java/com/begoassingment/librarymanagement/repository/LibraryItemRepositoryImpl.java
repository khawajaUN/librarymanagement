package com.begoassingment.librarymanagement.repository;

import com.begoassingment.librarymanagement.model.ItemType;
import com.begoassingment.librarymanagement.model.LibraryItem;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class LibraryItemRepositoryImpl implements LibraryItemRepository {
    private final List<LibraryItem> libraryItems = Collections.synchronizedList(new ArrayList<>());


    @Override
    public void save(LibraryItem item) {
        libraryItems.add(item);
    }

    @Override
    public List<LibraryItem> getAllItems() {
        return new ArrayList<>(libraryItems);
    }

    @Override
    public List<LibraryItem> getItemsByType(ItemType type) {
        synchronized (libraryItems) {
            return libraryItems.stream()
                    .filter(item -> item.getType() == type)
                    .collect(Collectors.toList());
        }
    }

    @Override
    public LibraryItem getItemByUniqueID(Long uniqueID) {
        for (LibraryItem item : libraryItems) {
            if (item.getUniqueID().equals(uniqueID)) {
                return item;
            }
        }
        return null;
    }
}
