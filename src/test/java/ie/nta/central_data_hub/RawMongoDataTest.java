package ie.nta.central_data_hub;

import org.bson.Document;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.List;

@SpringBootTest
public class RawMongoDataTest {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    public void testInspectRawEntityRoleCollection() {
        System.out.println("[DEBUG_LOG] Inspecting collection 'collection_entity_role'");
        List<Document> documents = mongoTemplate.getCollection("collection_entity_role").find().into(new java.util.ArrayList<>());
        for (Document doc : documents) {
            System.out.println("[DEBUG_LOG] Raw Document: " + doc.toJson());
        }
    }

    @Test
    public void testSearchEntitiesByIds106_108() {
        System.out.println("[DEBUG_LOG] Searching for entities in collection_entity with entity_id in (106, 107, 108)");
        for (int id : new int[]{106, 107, 108}) {
            Document doc = mongoTemplate.getCollection("collection_entity").find(new org.bson.Document("entity_id", id)).first();
            if (doc != null) {
                System.out.println("[DEBUG_LOG]   Found entity for ID " + id + ": " + doc.toJson());
            } else {
                System.out.println("[DEBUG_LOG]   No entity found for ID " + id);
            }
        }
    }
}
