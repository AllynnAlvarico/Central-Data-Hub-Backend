package ie.nta.central_data_hub;

import ie.nta.central_data_hub.domain.Contract;
import ie.nta.central_data_hub.repository.ContractRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class ContractDataTest {

    @Autowired
    private ContractRepository contractRepository;

    @Test
    public void testFetchContracts() {
        List<Contract> contracts = contractRepository.findAll();
        assertNotNull(contracts);
        System.out.println("Total contracts found: " + contracts.size());
        contracts.stream().limit(5).forEach(System.out::println);
    }
}
