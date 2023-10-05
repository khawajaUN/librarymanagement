package com.begoassingment.librarymanagement;

import com.begoassingment.librarymanagement.model.ItemType;
import com.begoassingment.librarymanagement.service.LibraryService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class LibraryManagementApplication {

	public static void main(String[] args) {
//		ConfigurableApplicationContext context = SpringApplication.run(LibraryManagementApplication.class, args);

		SpringApplication.run(LibraryManagementApplication.class, args);

//		LibraryService libraryService = context.getBean(LibraryService.class);
//
//		libraryService.addItem(1L, 5L ,ItemType.DVD, "Pi");
//		libraryService.addItem(2L,6L ,ItemType.VHS, "Pi");
//		libraryService.addItem(3L, 1L,ItemType.BOOK, "The Art Of Computer Programming Volumes 1-6");
//		libraryService.addItem(4L, 2L,ItemType.BOOK, "The Pragmatic Programmer");
//		libraryService.addItem(5L, 3L,ItemType.BOOK, "Concurrency In Practice");
//		libraryService.addItem(6L, 4L,ItemType.BOOK, "Introduction to Algorithms");
//		libraryService.addItem(7L, 5L,ItemType.DVD, "Pi");
//		libraryService.addItem(8L, 4L,ItemType.BOOK, "Introduction to Algorithms");
//		libraryService.addItem(9L, 6L,ItemType.VHS, "WarGames");
//		libraryService.addItem(10L, 6L,ItemType.VHS, "Hackers");
//		libraryService.addItem(11L, 4L,ItemType.BOOK, "Introduction to Algorithms");
//		libraryService.addItem(12L, 5L,ItemType.DVD, "pi");
//
//
//		libraryService.listAllItems();
//
//		libraryService.listItemsByType(ItemType.DVD);
//
//		libraryService.borrowItem(7L);
//		libraryService.listItemsDueForReturn();
//
//		libraryService.listAvailableItems();
//
//		context.close();
	}
}
