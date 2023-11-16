package com.example.mongodb;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.example.objects.MySecrets;
import com.example.secretsmanager.SecretsManager;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

@Configuration
@EnableMongoRepositories(basePackages = "com.example")
public class MongoDbConnectionConfig extends AbstractMongoClientConfiguration {

	@Value("${spring.data.mongodb.uri}")
    private String mongoUri;
	@Autowired
	SecretsManager secretsManager;
	private String database="";
	
	
	
	
    @Bean
    public MongoClient mongoClient() {
    	ObjectMapper objectMapper = new ObjectMapper();
    	MySecrets mySecret=null;
    	// Convert JSON string to MySecret object

    	try {
			 mySecret = objectMapper.readValue(secretsManager.getSecretsManager("DevDocumentDB"), MySecrets.class);
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	String connectionUri=String.format(mongoUri, mySecret.getUsername(), mySecret.getPassword(), mySecret.getHost(), mySecret.getPort());
        ConnectionString connectionString = new ConnectionString(connectionUri);
        database=mySecret.getDbClusterIdentifier();
        MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
                .applyConnectionString(connectionString).applyToSocketSettings(builder -> builder.connectTimeout(30000, TimeUnit.MILLISECONDS).readTimeout(30000, TimeUnit.MILLISECONDS))
                .build();
       
        return MongoClients.create(mongoClientSettings);
    }
//
//	@Override
//	protected String getDatabaseName() {
//		// TODO Auto-generated method stub
//		return "cloudcomputing";
//	}
//	 @Value("${spring.data.mongodb.host}")
//	    private String host;
//
//	    @Value("${spring.data.mongodb.port}")
//	    private int port;
//
//	    @Value("${spring.data.mongodb.database}")
//	    private String database;
//
	    @Override
	    protected String getDatabaseName() {
	        return database;
	    }

//	    @Override
//	    public MongoClient mongoClient() {
//	    	ObjectMapper objectMapper = new ObjectMapper();
//	    	MySecrets mySecret=null;
//	    	// Convert JSON string to MySecret object
//
//	    	try {
//				 mySecret = objectMapper.readValue(secretsManager.getSecretsManager("DevDocumentDB"), MySecrets.class);
//			} catch (JsonMappingException e) {
//				// TODO Auto-generated catch block
//				
//				e.printStackTrace();
//			} catch (JsonProcessingException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//	    	String connectionUri=String.format(mongoUri, mySecret.getUsername(), mySecret.getPassword(), mySecret.getHost(), mySecret.getPort(), mySecret.getDbClusterIdentifier());
//	        ConnectionString connectionString = new ConnectionString(connectionUri);	
//	    	
//	        MongoClientSettings settings = MongoClientSettings.builder()
//	                .applyToClusterSettings(builder ->
//	                        builder.hosts(Arrays.asList(new ServerAddress(host, port))))
//	                .build();
//	        return MongoClients.create(settings);
//	    }
	
}
