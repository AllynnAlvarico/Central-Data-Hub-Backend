package ie.nta.central_data_hub;

import ie.nta.central_data_hub.domain.assignment.EntityRole;
import ie.nta.central_data_hub.repository.EntityRoleRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class EntityRoleDataTest {

    @Autowired
    private EntityRoleRepository entityRoleRepository;

    @Test
    public void testFetchEntityRolesFromMongoDB() {
        List<EntityRole> associations = entityRoleRepository.findAll();
        assertNotNull(associations, "The fetched EntityRole list should not be null");
        System.out.println("[DEBUG_LOG] Count of EntityRole associations: " + associations.size());
        associations.forEach(assoc -> System.out.println("[DEBUG_LOG] " + assoc));
    }

    @Test
    public void testFindByEntityRoleId() {
        for (int i = 1; i <= 4; i++) {
            List<EntityRole> associations = entityRoleRepository.findByEntityRoleId(i);
            System.out.println("[DEBUG_LOG] Role ID " + i + " has " + associations.size() + " associations");
        }
    }
}
