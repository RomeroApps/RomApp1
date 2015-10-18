package com.romero.app;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerService {
	@Autowired
	private MongoTemplate mongoTemplate;

	public static final String COLLECTION_NAME = "customer";
	
	public void addPerson(Customer customer) {
		if (!mongoTemplate.collectionExists(Customer.class)) {
			mongoTemplate.createCollection(Customer.class);
		}		
		customer.setId(UUID.randomUUID().toString());
		mongoTemplate.
		mongoTemplate.insert(customer, COLLECTION_NAME);
	}
	
	public List<Customer> listCustomer() {
		return mongoTemplate.findAll(Customer.class, COLLECTION_NAME);
	}
	
	public void deleteCustomer(Customer customer) {
		mongoTemplate.remove(customer, COLLECTION_NAME);
	}
	
	public void updateCustomer(Customer customer) {
		mongoTemplate.insert(customer, COLLECTION_NAME);		
	}
}
