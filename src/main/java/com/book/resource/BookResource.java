package com.book.resource;

import com.book.exception.BookNotFoundException;
import com.book.model.Book;
import com.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookResource {
    @Autowired
    private BookService bookService;

    @GetMapping("/all")
    public ResponseEntity<List<Book>> getBooks(){
        return new ResponseEntity<>(bookService.getBooks(), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Book> addBook(@RequestBody Book book){
        return new ResponseEntity<>(bookService.addBook(book),HttpStatus.CREATED);
    }
    @PutMapping("/edit")
    public ResponseEntity<Book> editBook(@RequestBody Book book) throws BookNotFoundException {
        return new ResponseEntity<>(bookService.editBook(book),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteBook(@PathVariable long id) throws BookNotFoundException {
        bookService.deleteBook(id);
        return "Success";
    }
}
