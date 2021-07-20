package com.api.book.bootrestbook.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.book.bootrestbook.entities.Book;
import com.api.book.bootrestbook.services.BookService;

@RestController
public class BookController {

	@Autowired(required = true)
	private BookService bookService;

	@GetMapping("/books")
	public List<Book> getBooks() {

		return this.bookService.getAllBooks();
	}

	@GetMapping("/book/{id}")
	public Book getBook(@PathVariable("id") int id) {
		return bookService.getBookById(id);
	}

	// add book through POST method
	@PostMapping("/books")
	public Book addBookq(@RequestBody Book book) {

		Book b = this.bookService.addBook(book);
		System.out.println(b);
		return b;
	}

	// delete book handler

	@DeleteMapping("/books/{bookId}")
	public void deleteBook(@PathVariable("bookId") int bookId) {
		this.bookService.deleteBook(bookId);
		
	}
}