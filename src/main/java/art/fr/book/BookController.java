package art.fr.book;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api")
@CrossOrigin("*")
public class BookController {
    private final BookService service;
    private final KafkaTemplate<String, Book> kafkaTemplate;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/create/book")
    public Book addBook(@Valid @RequestBody Book book) {
        return service.saveBook(book);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/fetch/books")
    public List<Book> getBooks() {
        return service.getBooks();
    }

    @GetMapping("/send/{id}/{topic}")
    public Book send(@PathVariable  Long id, @PathVariable String topic){
        Book book = service.getBook(id);
        kafkaTemplate.send(topic,book.getAuthor(), book);
        return book;
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello git action";
    }
}

