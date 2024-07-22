package com.example.springmongodb1.config;

import com.example.springmongodb1.model.GroceryItem;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;
import org.springframework.data.mongodb.core.mapping.MongoSimpleTypes;

@Configuration
public class MongoDBConfig {
	@Autowired
	private MongoTemplate mongoTemplate;
	
	@PostConstruct
	public void init() {
		if(!mongoTemplate.collectionExists(GroceryItem.class)) {
			mongoTemplate.createCollection(GroceryItem.class);
		}
	}
	
	//bỏ đưa _class "com.example.springmongodb1.model.GroceryItem"
//	@Bean
//	public MongoMappingContext mongoMappingContext() {
//		MongoMappingContext mappingContext = new MongoMappingContext();
//		mappingContext.setAutoIndexCreation(true);
//		mappingContext.setAutoIndexCreation(false);
//		mappingContext.setSimpleTypeHolder(MongoSimpleTypes.HOLDER);
//		return mappingContext;
//	}
}