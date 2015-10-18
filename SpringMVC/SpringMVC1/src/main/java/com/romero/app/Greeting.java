package com.romero.app;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

@Service
@Scope(WebApplicationContext.SCOPE_REQUEST)
public class Greeting {

    private long id;
    private String content;

    public void setId(long id) {
		this.id = id;
	}

	public void setContent(String content) {
		this.content = content;
	}

//	public Greeting(long id, String content) {
//        this.id = id;
//        this.content = content;
//    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
    
//	   private int empId;
//	   
//	    public int getEmpId() {
//	        return empId;
//	    }
//	 
//	    public void setEmpId(int empId) {
//	        this.empId = empId;
//	    }
}
