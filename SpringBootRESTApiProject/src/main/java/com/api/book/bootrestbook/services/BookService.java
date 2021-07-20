package com.api.book.bootrestbook.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

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
		book = list.stream().filter(e -> e.getId() == id).findFirst().get();
		return book;
	}

}
