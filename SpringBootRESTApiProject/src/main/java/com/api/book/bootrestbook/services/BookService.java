package com.api.book.bootrestbook.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.api.book.bootrestbook.dao.BookRepository;
import com.api.book.bootrestbook.entities.Book;

@Service
public class BookService {

	@Autowired
	BookRepository bookRepository;

//	private static List<Book> list = new ArrayList<>();
//
//	static {
//		list.add(new Book(12, "Python book", "author pyhton"));
//		list.add(new Book(45, "ml book", "author ml"));
//		list.add(new Book(65, "spring book", "author spring"));
//		list.add(new Book(38, ".Net book", "author .Net"));
//	}

	// get all books
	public List<Book> getAllBooks() {
		List<Book> list = (List<Book>) this.bookRepository.findAll();
		return list;
	}

	// get single book by id
	public Book getBookById(int id) {
		Book book = null;
		try {
			// book = list.stream().filter(e -> e.getId() == id).findFirst().get();
			book = this.bookRepository.findById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return book;
	}

	// adding the book
	public Book addBook(Book b) {
		// list.add(b);
		Book res = this.bookRepository.save(b);
		return res;
	}

	// delete the book

	public void deleteBook(int bid) {

//		list = list.stream().filter(book -> {
//			if (book.getId() != bid) {
//				return true;
//			} else {
//				return false;
//			}
//		}).collect(Collectors.toList());

		this.bookRepository.deleteById(bid);

	}

	// update the book
	public void updateBook(Book book, int bookId) {

//		list = list.stream().map(b -> {
//			if (b.getId() == bookId) {
//				b.setTitle(book.getTitle());
//				b.setAuthor(book.getAuthor());
//			}
//			return b;
//		}).collect(Collectors.toList());

		// using boot jpa
		book.setId(bookId);
		this.bookRepository.save(book);

	}

}
