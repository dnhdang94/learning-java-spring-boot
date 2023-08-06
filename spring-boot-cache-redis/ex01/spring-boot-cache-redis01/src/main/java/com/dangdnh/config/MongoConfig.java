package com.dangdnh.config;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;

@Configuration
public class MongoConfig extends AbstractMongoClientConfiguration {

    @Value("${spring.mongo.connectionString}")
    private String connectionString;

    @Value("${spring.mongo.databaseName}")
    private String databaseName;

    @Override
    protected String getDatabaseName() {
        return databaseName;
    }

    @Override
    protected MongoClientSettings mongoClientSettings() {
        ConnectionString connStr = new ConnectionString(connectionString);
        return MongoClientSettings.builder()
                .applyConnectionString(connStr)
                .build();
    }

    @Override
    protected MongoClient createMongoClient(MongoClientSettings settings) {
        return MongoClients.create(settings);
    }
}
