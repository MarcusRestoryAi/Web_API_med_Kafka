package marcus.kafka.kafka;

import marcus.kafka.Repository.UserRepository;
import marcus.kafka.payload.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaConsumerDb {

    @Autowired
    private UserRepository userRepository;

    @KafkaListener(topics = "javaJsonGuides", groupId = "otherGroup")
    public void writeToDb(User user) {

        System.out.println(user);

        System.out.println("Skickar data till DB!");
        //Skicka data till DB
        userRepository.save(user);
    }
}
