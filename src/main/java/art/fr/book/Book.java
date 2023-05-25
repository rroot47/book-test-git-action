package art.fr.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Book {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;
    @Column(name = "author")
    private String author;
    @Column(name = "title")
    private String title;
    @Column(name = "publication_year")
    private int year;
}
