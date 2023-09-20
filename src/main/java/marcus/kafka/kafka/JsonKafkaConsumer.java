package marcus.kafka.kafka;

import marcus.kafka.Repository.UserRepository;
import marcus.kafka.payload.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaConsumer.class);

    @Autowired
    private UserRepository userRepository;

    @KafkaListener(topics = "javaJsonGuides", groupId = "myGroup")
    public void consume(User user) {

        LOGGER.info(String.format("Json message recieved -> %s", user.toString()));
/*
        System.out.println(user);

        System.out.println("Skickar data till DB!");
        //Skicka data till DB
        userRepository.save(user);

 */
    }
}
