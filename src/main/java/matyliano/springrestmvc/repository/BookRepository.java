package matyliano.springrestmvc.repository;

import matyliano.springrestmvc.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Long> {
}
