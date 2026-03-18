package ie.nta.central_data_hub;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableMongoRepositories
//@RestController
public class CentralDataHubApplication{

    private static final Logger logger = LoggerFactory.getLogger(CentralDataHubApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(CentralDataHubApplication.class, args);

    }
//    @GetMapping("/ping")  // ← add this
//    public String ping() {
//        return "pong";
//    }

}
