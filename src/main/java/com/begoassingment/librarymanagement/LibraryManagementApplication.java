package com.begoassingment.librarymanagement;

import com.begoassingment.librarymanagement.controller.LibraryController;
import com.begoassingment.librarymanagement.model.ItemType;
import com.begoassingment.librarymanagement.service.LibraryService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class LibraryManagementApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(LibraryManagementApplication.class, args);

//		SpringApplication.run(LibraryManagementApplication.class, args);

		LibraryController libraryController = context.getBean(LibraryController.class);

		libraryController.addItem(1L, 5L ,ItemType.DVD, "Pi");
		libraryController.addItem(2L,6L ,ItemType.VHS, "Pi");
		libraryController.addItem(3L, 1L,ItemType.BOOK, "The Art Of Computer Programming Volumes 1-6");
		libraryController.addItem(4L, 2L,ItemType.BOOK, "The Pragmatic Programmer");
		libraryController.addItem(5L, 3L,ItemType.BOOK, "Concurrency In Practice");
		libraryController.addItem(6L, 4L,ItemType.BOOK, "Introduction to Algorithms");
		libraryController.addItem(7L, 5L,ItemType.DVD, "Pi");
		libraryController.addItem(8L, 4L,ItemType.BOOK, "Introduction to Algorithms");
		libraryController.addItem(9L, 6L,ItemType.VHS, "WarGames");
		libraryController.addItem(10L, 6L,ItemType.VHS, "Hackers");
		libraryController.addItem(11L, 4L,ItemType.BOOK, "Introduction to Algorithms");
		libraryController.addItem(12L, 5L,ItemType.DVD, "pi");

		libraryController.listAllItems();

		libraryController.listItemsByType(ItemType.DVD);

		libraryController.borrowItem(7L);
		libraryController.listItemsDueForReturn();

		libraryController.listAvailableItems();

		context.close();
	}
}
