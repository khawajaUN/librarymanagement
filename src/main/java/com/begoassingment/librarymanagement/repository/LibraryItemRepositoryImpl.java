package com.begoassingment.librarymanagement.repository;

import com.begoassingment.librarymanagement.model.ItemType;
import com.begoassingment.librarymanagement.model.LibraryItem;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class LibraryItemRepositoryImpl implements LibraryItemRepository {
    private final List<LibraryItem> libraryItems = new ArrayList<>();

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
        List<LibraryItem> itemsOfType = new ArrayList<>();
        for (LibraryItem item : libraryItems) {
            if (item.getType() == type) {
                itemsOfType.add(item);
            }
        }
        return itemsOfType;
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
