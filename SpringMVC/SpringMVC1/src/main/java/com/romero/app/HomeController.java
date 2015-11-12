package com.romero.app;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

import com.romero.app.Greeting;

import com.romero.app.Customer;

/**
 * Handles requests for the application home page.
 */
@Controller
@Scope("request")
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	private CustomerRepository customerRepository;
	
//	@Autowired
//	public void setRepository(){
//		this.customerRepository.save(new Customer("Angela", "Romero"));
//		// save a couple of customers
//	}
	
	@Autowired
	private CustomerService customerService;
	
	   @RequestMapping(value = "/", method = RequestMethod.GET)  
		public String getHome(ModelMap model) {  
	        model.addAttribute("customerList", customerService.listCustomer());  
	        return "output";  
	    }  
	   
	   @RequestMapping(value = "/customer", method = RequestMethod.GET)  
		public String getCustomerList(ModelMap model) {  
	        model.addAttribute("customerList", customerService.listCustomer());  
	        return "output";  
	    }  

	    @RequestMapping(value = "/customer/save", method = RequestMethod.POST)  
		public View createPerson(@ModelAttribute Customer customer, ModelMap model) {
	    	if(StringUtils.hasText(customer.getId())) {
	    		customerService.updateCustomer(customer);
	    	} else {
	    		customerService.addPerson(customer);
	    	}
	    	return new RedirectView("/app/customer");  
	    }
	        
	    @RequestMapping(value = "/customer/delete", method = RequestMethod.GET)  
		public View deleteCustomer(@ModelAttribute Customer customer, ModelMap model) {  
	        customerService.deleteCustomer(customer);  
	        return new RedirectView("/app/customer");  
	    }
	
	    
	    @RequestMapping(value = "/emp/get/{id}", method = RequestMethod.GET)
	    public String getEmployee(Locale locale, Model model,@PathVariable("id") int id) {
	        logger.info("Welcome user! Requested Emp ID is: "+id);
	        Date date = new Date();
	        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
	         
	        String formattedDate = dateFormat.format(date);
	         
	        model.addAttribute("serverTime", formattedDate );
	        model.addAttribute("id", id);
	        model.addAttribute("name", "Pankaj");
	         
	        return "employee";
	    }
	     
	    @RequestMapping(value="/login")
	    public String login(HttpServletRequest request, Model model){
	        return "login";
	    }
	     
	    @RequestMapping(value="/logout")
	    public String logout(){
	        return "logout";
	    }
	     
	    @RequestMapping(value="/denied")
	    public String denied(){
	        return "denied";
	    }

	
}
