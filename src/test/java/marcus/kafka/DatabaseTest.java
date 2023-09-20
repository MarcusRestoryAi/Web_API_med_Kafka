package marcus.kafka;

import marcus.kafka.Repository.UserRepository;
import marcus.kafka.payload.User;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DatabaseTest {

    @Autowired
    UserRepository userRepository;

    static User testUser;

    @BeforeEach
    void setUp() {
        System.out.println("Before Test");
    }

    @AfterEach
    void tearDown() {
        System.out.println("After Test");
    }

    @Test
    @Order(1)
    void createUser() {
        //Skapa ett objekt av User med specifik data
        User user = new User();
        user.setFirstName("A");
        user.setLastName("B");

        //Spara user till DB
        testUser = userRepository.save(user);

        assertNotNull(userRepository.findById(testUser.getId()).get().getFirstName());

        System.out.println(testUser.getId());
    }

    @Test
    @Order(2)
    void updateUser() {
        //Hämta User med id 1
        User fetchedUser = userRepository.findById(testUser.getId()).get();
        assertNotNull(fetchedUser);

        //Updatera värdet i fetchedUser
        fetchedUser.setFirstName("Niklas");
        userRepository.save(fetchedUser);
        assertEquals("Niklas", userRepository.findById(testUser.getId()).get().getFirstName());
    }

    @Test
    @Order(3)
    void removeUser() {
        //Kontrollera att user med ID 1 finns
        assertNotNull(userRepository.findById(testUser.getId()).get());

        //Ta bort user med ID 1 och konroller att user är borta
        userRepository.deleteById(testUser.getId());
        assertTrue(userRepository.findById(testUser.getId()).isEmpty());
    }
}
