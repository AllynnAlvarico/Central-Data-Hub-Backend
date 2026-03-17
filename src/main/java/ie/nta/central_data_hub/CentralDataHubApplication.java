package ie.nta.central_data_hub;

import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.List;

@SpringBootApplication
public class CentralDataHubApplication {

    private static final Logger logger = LoggerFactory.getLogger(CentralDataHubApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(CentralDataHubApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(MongoTemplate mongoTemplate, com.mongodb.client.MongoClient mongoClient) {
        return args -> {
            try {
                Document ping = new Document("ping", 1);
                mongoTemplate.getDb().runCommand(ping);
                logger.info("Pinged your deployment. You successfully connected to MongoDB!");

                // List collections in the current database
                String currentDbName = mongoTemplate.getDb().getName();
                logger.info("Listing collections in database '{}':", currentDbName);
                for (String collection : mongoTemplate.getDb().listCollectionNames()) {
                    logger.info(" - {}", collection);
                }

                for (String dbName : mongoClient.listDatabaseNames()) {
                    if (!dbName.equals(currentDbName) && !dbName.equals("admin") && !dbName.equals("local")) {
                        logger.info("Listing collections in database '{}':", dbName);
                        for (String collection : mongoClient.getDatabase(dbName).listCollectionNames()) {
                            logger.info(" - {}", collection);
                        }
                    }
                }

            } catch (Exception e) {
                logger.error("Failed to connect to MongoDB: {}", e.getMessage());
            }
        };
    }
}
