package art.fr.book;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
   private final BookRepository bookRepository;

    public Book saveBook(Book book){
        return bookRepository.save(book);
    }
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    public Book getBook(Long id) {
        return bookRepository.findById(id).get();
    }

}