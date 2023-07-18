package com.example.mongodb;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.MongoClientSettings;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

@Configuration
@EnableMongoRepositories(basePackages = "com.example")
public class MongoDbConnectionConfig extends AbstractMongoClientConfiguration {
	 @Value("${spring.data.mongodb.host}")
	    private String host;

	    @Value("${spring.data.mongodb.port}")
	    private int port;

	    @Value("${spring.data.mongodb.database}")
	    private String database;

	    @Override
	    protected String getDatabaseName() {
	        return database;
	    }

	    @Override
	    public MongoClient mongoClient() {
	        MongoClientSettings settings = MongoClientSettings.builder()
	                .applyToClusterSettings(builder ->
	                        builder.hosts(Arrays.asList(new ServerAddress(host, port))))
	                .build();
	        return MongoClients.create(settings);
	    }

}
