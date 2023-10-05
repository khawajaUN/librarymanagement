package com.begoassingment.librarymanagement.service;

import com.begoassingment.librarymanagement.model.DueItem;
import com.begoassingment.librarymanagement.model.LibraryItem;
import com.begoassingment.librarymanagement.model.ItemType;
import com.begoassingment.librarymanagement.repository.LibraryItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class LibraryService {
    private final LibraryItemRepository libraryItemRepository;

    @Autowired
    public LibraryService(LibraryItemRepository libraryItemRepository) {
        this.libraryItemRepository = libraryItemRepository;
    }


    public void addItem(Long uniqueID, Long itemID ,ItemType type, String title) {
        LibraryItem item = new LibraryItem(uniqueID, itemID, type, title);
        libraryItemRepository.save(item);
    }


    public void borrowItem(Long uniqueID) {
        LibraryItem item = libraryItemRepository.getItemByUniqueID(uniqueID);

        if (item == null) {
            System.out.println("Item with Unique ID " + uniqueID + " not found in the library.");
            return;
        }

        if (item.isAvailable()) {
            item.setAvailable(false);

            LocalDate returnDate = LocalDate.now().plusWeeks(1);
            item.setDueDate(returnDate);

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String formattedReturnDate = returnDate.format(formatter);

            System.out.println("Item with Unique ID " + uniqueID + " has been borrowed.");
            System.out.println("Return Date for Item with Unique ID " + uniqueID + ": " + formattedReturnDate);
        } else {
            System.out.println("Item with Unique ID " + uniqueID + " is already borrowed.");
        }
    }
    public void returnItem(Long uniqueID) {
        LibraryItem item = libraryItemRepository.getItemByUniqueID(uniqueID);

        if (item == null) {
            System.out.println("Item with Unique ID " + uniqueID + " not found in the library.");
            return;
        }

        if (!item.isAvailable()) {
            item.setAvailable(true);
            item.setDueDate(null);
            System.out.println("Item with Unique ID " + uniqueID + " has been returned.");
        } else {
            System.out.println("Item with Unique ID " + uniqueID + " is already available.");
        }
    }

    public void listAllItems() {
        List<LibraryItem> items = libraryItemRepository.getAllItems();
        if (items.isEmpty()) {
            System.out.println("The library is empty.");
        } else {
            System.out.println("List of Library Items:");
            for (LibraryItem item : items) {
                System.out.println("Unique ID: " + item.getUniqueID() +
                        ", Item ID: " + item.getItemID() +
                        ", Type: " + item.getType() +
                        ", Title: " + item.getTitle() +
                        ", Available: " + item.isAvailable() +
                        ", Due Date: " + (item.getDueDate() != null ? item.getDueDate() : "N/A"));
            }
        }
    }

    public void listItemsByType(ItemType type) {
        List<LibraryItem> items = libraryItemRepository.getItemsByType(type);
        if (items.isEmpty()) {
            System.out.println("No items of type " + type + " found in the library.");
        } else {
            System.out.println("List of " + type + " Items:");
            for (LibraryItem item : items) {
                System.out.println("Unique ID: " + item.getUniqueID() +
                        ", Item ID: " + item.getItemID() +
                        ", Title: " + item.getTitle() +
                        ", Available: " + item.isAvailable() +
                        ", Due Date: " + (item.getDueDate() != null ? item.getDueDate() : "N/A"));
            }
        }
    }


    public List<DueItem> listItemsDueForReturn() {
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        List<LibraryItem> items = libraryItemRepository.getAllItems();
        List<DueItem> dueItems = new ArrayList<>();


        for (LibraryItem item : items) {
            LocalDate dueDate = item.getDueDate();
            if (!item.isAvailable() && dueDate != null) {
                String formattedDueDate = dueDate.format(formatter);
                DueItem dueItem = new DueItem();
                dueItem.setUniqueID(item.getUniqueID());
                dueItem.setItemID(item.getItemID());
                dueItem.setType(item.getType());
                dueItem.setTitle(item.getTitle());
                dueItem.setDueDate(formattedDueDate);
                dueItems.add(dueItem);


                System.out.println("This is the due item Array List" + dueItem);
            }
        }

        return dueItems;

    }


    public void listAvailableItems() {
        List<LibraryItem> items = libraryItemRepository.getAllItems();
        if (items.isEmpty()) {
            System.out.println("The library is empty.");
            return;
        }

        System.out.println("List of Available Items:");
        for (LibraryItem item : items) {
            if (item.isAvailable()) {
                System.out.println("Unique ID: " + item.getUniqueID() +
                        ", Item ID: " + item.getItemID() +
                        ", Type: " + item.getType() +
                        ", Title: " + item.getTitle());
            }
        }
    }


}

