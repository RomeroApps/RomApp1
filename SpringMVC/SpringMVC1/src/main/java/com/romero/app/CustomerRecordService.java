package com.romero.app;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

public class CustomerRecordService {

	private MongoTemplate mongoTemplate;
	
	public static final String COLLECTION_NAME = "customer_record";
	
	public void addCustomerRecord(CustomerRecord customerrecord){
		if (!mongoTemplate.collectionExists(CustomerRecord.class)){
			mongoTemplate.createCollection(CustomerRecord.class);
		}
		customerrecord.setId(UUID.randomUUID().toString());
		
		mongoTemplate.insert(customerrecord, COLLECTION_NAME);
	}
	
}
