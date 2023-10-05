package com.begoassingment.librarymanagement.controller;
import com.begoassingment.librarymanagement.model.DueItem;
import com.begoassingment.librarymanagement.model.ItemType;
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

//    @PostMapping("/borrowItem")
//    public void borrowItem(@RequestParam Long uniqueID) {
//        libraryService.borrowItem(uniqueID);
//    }

//    @PostMapping("/returnItem")
//    public void returnItem(@RequestParam Long uniqueID) {
//        libraryService.returnItem(uniqueID);
//    }

//    @GetMapping("/getAllItems")
//    public List<LibraryItem> getAllItems() {
//        return libraryService.getAllItems();
//    }

//    @GetMapping("/getItemsByType")
//    public List<LibraryItem> getItemsByType(@RequestParam ItemType type) {
////        return libraryService.getItemsByType(type);
//    }

//    @GetMapping("/getItemsDueForReturn")
//    public List<DueItem> getItemsDueForReturn() {
//        return libraryService.listItemsDueForReturn();
//    }

//    @GetMapping("/getAvailableItems")
//    public List<LibraryItem> getAvailableItems() {
//        return libraryService.getAvailableItems();
//    }
}


