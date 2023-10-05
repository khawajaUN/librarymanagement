package com.begoassingment.librarymanagement.model;

import java.time.LocalDate;

public class LibraryItem {
    private Long uniqueID;
    private Long itemID;
    private ItemType type;
    private String title;
    private boolean available;
    private LocalDate dueDate;

    public LibraryItem(Long uniqueID, Long itemID, ItemType type, String title) {
        this.uniqueID = uniqueID;
        this.itemID = itemID;
        this.type = type;
        this.title = title;
        this.available = true;
        this.dueDate = null;
    }

    public Long getUniqueID() {
        return uniqueID;
    }

    public void setUniqueID(Long uniqueID) {
        this.uniqueID = uniqueID;
    }

    public Long getItemID() {
        return itemID;
    }

    public void setItemID(Long itemID) {
        this.itemID = itemID;
    }

    public ItemType getType() {
        return type;
    }

    public void setType(ItemType type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }
}
