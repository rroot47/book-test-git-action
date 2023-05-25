package art.fr.service;


import art.fr.entities.Book;
import art.fr.repository.BookRepository;
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

}
