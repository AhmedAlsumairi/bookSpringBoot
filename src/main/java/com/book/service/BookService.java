package com.book.service;

import com.book.exception.BookNotFoundException;
import com.book.model.Book;
import com.book.repositroy.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    // Get Books
    public List<Book> getBooks(){

        return bookRepository.findAll();

    }

    // Add Book
    public Book addBook(Book book){
        return bookRepository.save(book);
    }


    // update Book
    public Book editBook(Book book) throws BookNotFoundException {
        Book bookEdit = bookRepository.findById(book.getId()).orElseThrow(()-> new BookNotFoundException("Book ID Not Found"));
        return bookRepository.save(book);
    }


    //delete Book
    public void deleteBook(long bookID) throws BookNotFoundException {
        Book book = bookRepository.findById(bookID).orElseThrow(()-> new BookNotFoundException("Book ID Not Found"));
        bookRepository.deleteById(bookID);
    }
}
