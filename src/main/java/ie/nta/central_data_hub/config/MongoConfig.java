package ie.nta.central_data_hub.config;


import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.ServerApi;
import com.mongodb.ServerApiVersion;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;

@Configuration
public class MongoConfig extends AbstractMongoClientConfiguration {

    @Value("${spring.mongodb.uri}")
    private String connectionString;

    @Value("${spring.mongodb.database}")
    private String databaseName;

    @Bean
    public com.mongodb.client.MongoClient mongoClient() {
        return com.mongodb.client.MongoClients.create(mongoClientSettings());
    }

    @Override
    public MongoClientSettings mongoClientSettings() {
        ServerApi serverApi = ServerApi.builder()
                .version(ServerApiVersion.V1)
                .build();

        return MongoClientSettings.builder()
                .applyConnectionString(new ConnectionString(connectionString))
                .serverApi(serverApi)
                .build();
    }

    @Override
    protected String getDatabaseName() {
        return databaseName;
    }
}
