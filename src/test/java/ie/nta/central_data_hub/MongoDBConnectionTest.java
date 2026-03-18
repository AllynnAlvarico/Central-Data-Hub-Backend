package ie.nta.central_data_hub;

import ie.nta.central_data_hub.domain.Entity;
import ie.nta.central_data_hub.repository.EntityRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class MongoDBConnectionTest {

    @Autowired
    private EntityRepository entityRepository;

    @Test
    public void testFetchDataFromMongoDB() {
        // Fetch all entities from the collection
        List<Entity> entities = entityRepository.findAll();

        // Assert that the result is not null
        assertNotNull(entities, "The fetched entities list should not be null");

        // Print the fetched entities for verification
        entities.forEach(System.out::println);
    }
}