package art.fr.book;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.json.JsonMapper;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class BookConsumer {

    @KafkaListener(topics = "R1", groupId = "r1-1")
    public void onMessage(ConsumerRecord<String, String> consumerRecord) throws JsonProcessingException {
        System.out.println("***************************");
        Book book = bookParse(consumerRecord.value());
        System.out.println(" => " + book.getAuthor() + " ," + book.getTitle() + " , " + book.getYear());
        System.out.println("***************************");
    }

    private Book bookParse(String book) throws JsonProcessingException {
        JsonMapper jsonMapper = new JsonMapper();
        return jsonMapper.readValue(book, Book.class);
    }
}
