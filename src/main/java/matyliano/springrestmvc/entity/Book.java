package matyliano.springrestmvc.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "books")
public class Book extends AbstractEntity<Long>{

    private String title;
    private String author;

}
