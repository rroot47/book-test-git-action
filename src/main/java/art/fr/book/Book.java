package art.fr.book;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;
    @Column(name = "author")
    private String author;
    @Column(name = "title")
    private String title;
    @Column(name = "publication_year")
    private String year;
}
