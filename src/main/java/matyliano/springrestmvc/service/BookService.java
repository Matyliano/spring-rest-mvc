package matyliano.springrestmvc.service;

import matyliano.springrestmvc.entity.Book;
import matyliano.springrestmvc.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private  BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book save ( Book book){
        return bookRepository.save(book);
    }

    public Optional<Book> getBook(Long id){
        return bookRepository.findById(id);
    }

    public Book update(Book book){
        Optional<Book> newBook = bookRepository.findById(book.getId());
        if(newBook!= null){
            bookRepository.save(book);
        }
        return book;
    }

    public List<Book> findAll(){
        return bookRepository.findAll();
    }

    public void delete(Book book){
        bookRepository.delete(book);
    }
}
