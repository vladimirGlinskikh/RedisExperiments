package kz.zhelezyaka.redisexperiment.controller;

import kz.zhelezyaka.redisexperiment.model.Book;
import kz.zhelezyaka.redisexperiment.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {
    private final static Logger logger = LoggerFactory.getLogger(BookController.class);

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public ResponseEntity<List<Book>> findAll() {
        long startTime = System.currentTimeMillis();
        List<Book> books = bookService.findAll();
        long endTime = System.currentTimeMillis() - startTime;

        logger.info("Duration = {}", endTime);
        return ResponseEntity.status(HttpStatus.OK)
                .body(books);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> findById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(bookService.findById(id).get());
    }

    @PostMapping
    public ResponseEntity<Book> create(@RequestBody Book book) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(bookService.save(book));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> update(@PathVariable Long id, @RequestBody Book book) {
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(bookService.save(book));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        bookService.deleteById(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .build();
    }
}
