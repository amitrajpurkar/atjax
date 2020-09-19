package com.anr.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

//import cz.jirutka.spring.embedmongo.EmbeddedMongoFactoryBean;

@Configuration
public class MongoConfig {

    private static final String MONGO_DB_URL = "localhost";
    private static final String MONGO_DB_NAME = "test";

    @Bean
    public MongoTemplate mongoTemplate() throws Exception {
        // String localURI = "mongodb://localhost:27017/test";
        String localURI = "mongodb://localhost:27017/test?maxPoolSize=20&minPoolSize=3&appName=TestApp&maxIdleTimeMS=2000";
        ConnectionString connectionString = new ConnectionString(localURI);
        MongoClientSettings mongoClientSettings = MongoClientSettings.builder().applyConnectionString(connectionString)
                .build();
        MongoClient mdbClient = MongoClients.create(mongoClientSettings);

        return new MongoTemplate(mdbClient, "test");
    }

}
