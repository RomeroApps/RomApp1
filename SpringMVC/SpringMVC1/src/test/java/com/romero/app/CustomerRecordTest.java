package com.romero.app;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CustomerRecordTest {

	@Test
	public void TestCustomerRecord_SetId(){
		CustomerRecord customerrecord = new CustomerRecord(); 
		customerrecord.setId("2");
		String IdTest = customerrecord.getId();
		assertEquals("2", IdTest);
		
	}

	@Test
	public void TestCustomerRecord_SetDetails(){
		CustomerRecord customerrecord = new CustomerRecord(); 
		customerrecord.setDetails("Details Test Text");
		String detailsTest = customerrecord.getDetails();
		assertEquals("Details Test Text", detailsTest);
		
	}
	
}
