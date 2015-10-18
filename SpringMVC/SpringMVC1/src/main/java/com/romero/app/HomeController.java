package com.romero.app;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	
	
	private Greeting Greeting;
	
	@Autowired
    public void setGreeting(Greeting obj) {
        this.Greeting = obj;
    }
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home Keith! The client locale is {}.", locale);
		
		int count = 1;
        while (count < 11) {
            System.out.println("Count is: " + count);
            count++;
        }
        
        List<String> list = new ArrayList<String>();
        list.add("hello");
        String s = list.get(0);   // no cast
		
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	@RequestMapping(value = "/greet", method = RequestMethod.GET)
	public String greet(Locale locale, Model model) {
		logger.info("Greetings..... Keith! The client locale is {}.", locale);
		System.out.println(Greeting.hashCode());
		int count = 1;
        while (count < 11) {
            System.out.println("Count is: " + count);
            count++;
        }
        
        List<String> list = new ArrayList<String>();
        list.add("hello");
        String s = list.get(0);   // no cast
		
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
}
