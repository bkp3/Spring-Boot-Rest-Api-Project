package com.api.book.bootrestbook.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.api.book.bootrestbook.entities.Book;

@Service
public class BookService {

	private static List<Book> list = new ArrayList<>();

	static {
		list.add(new Book(12, "Python book", "author pyhton"));
		list.add(new Book(45, "ml book", "author ml"));
		list.add(new Book(65, "spring book", "author spring"));
		list.add(new Book(38, ".Net book", "author .Net"));
	}

	// get all books
	public List<Book> getAllBooks() {
		return list;
	}

	// get single book by id
	public Book getBookById(int id) {
		Book book = null;
		try {
			book = list.stream().filter(e -> e.getId() == id).findFirst().get();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return book;
	}

	// adding the book
	public Book addBook(Book b) {
		list.add(b);
		return b;
	}

	// delete the book

	public void deleteBook(int bid) {

		list = list.stream().filter(book -> {
			if (book.getId() != bid) {
				return true;
			} else {
				return false;
			}
		}).collect(Collectors.toList());

	}

	// update the book
	public void updateBook(Book book, int bookId) {

		list = list.stream().map(b -> {
			if (b.getId() == bookId) {
				b.setTitle(book.getTitle());
				b.setAuthor(book.getAuthor());
			}
			return b;
		}).collect(Collectors.toList());

	}

}
