package com.begoassingment.librarymanagement.controller;
import com.begoassingment.librarymanagement.model.DueItem;
import com.begoassingment.librarymanagement.model.ItemType;
import com.begoassingment.librarymanagement.model.LibraryItem;
import com.begoassingment.librarymanagement.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/library")
public class LibraryController {
    private final LibraryService libraryService;

    @Autowired
    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @PostMapping("/addItem")
    public void addItem(@RequestParam Long uniqueID, @RequestParam Long itemID, @RequestParam ItemType type, @RequestParam String title) {
        libraryService.addItem(uniqueID, itemID, type, title);
    }

    @PostMapping("/borrowItem")
    public void borrowItem(@RequestParam Long uniqueID) {
        libraryService.borrowItem(uniqueID);
    }

    @PostMapping("/returnItem")
    public void returnItem(@RequestParam Long uniqueID) {
        libraryService.returnItem(uniqueID);
    }

    @GetMapping("/listAllItems")
    public void listAllItems() {
        libraryService.listAllItems();
    }

    @GetMapping("/listItemsByType")
    public void listItemsByType(@RequestParam ItemType type) {
        libraryService.listItemsByType(type);
    }

    @GetMapping("/listItemsDueForReturn")
    public List<DueItem> listItemsDueForReturn() {
        return libraryService.listItemsDueForReturn();
    }

    @GetMapping("/listAvailableItems")
    public void listAvailableItems() {
        libraryService.listAvailableItems();
    }
}


