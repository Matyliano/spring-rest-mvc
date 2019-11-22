package matyliano.springrestmvc.controller;

import matyliano.springrestmvc.entity.Book;
import matyliano.springrestmvc.exception.BookNotFoundException;
import matyliano.springrestmvc.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
public class BookController {

    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }


    @PostMapping
    public ResponseEntity<?> save(@RequestBody Book book){
         Book savedBook = bookService.save(book);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/id")
                .buildAndExpand(savedBook.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

     @PutMapping
    public ResponseEntity<?> update(@RequestBody Book book){
        Optional<Book> bookToUpdate = bookService.getBook(book.getId());
         if (!bookToUpdate.isPresent()) {
             return ResponseEntity.notFound().build();
         }

         return new ResponseEntity<>(bookService.update(book), HttpStatus.OK);

     }
      @GetMapping("/books/{id}")
      public ResponseEntity<Optional<Book>> getById(@PathVariable Long id ){
        if(id == null){
            throw new BookNotFoundException("Book not found");
        }
        return new ResponseEntity<>(bookService.getBook(id), HttpStatus.OK);
      }


}
