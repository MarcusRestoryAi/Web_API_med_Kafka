package marcus.kafka.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {

    private KafkaTemplate<String, String> kafkaTemplate;
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducer.class);

    //Constructor
    public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String message) {
        kafkaTemplate.send("javaGuides", message);
        // LOGGER.info("Message Sent: " + message);
           LOGGER.info(String.format("Message sent: %s", message));
    }
}
