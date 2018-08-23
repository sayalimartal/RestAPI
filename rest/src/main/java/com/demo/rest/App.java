package com.demo.rest;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.demo.rest.pojo.Customer;
import com.demo.rest.service.CustomerService;

/**
 * Customer Operations
 *
 */
@SpringBootApplication
public class App 
{
    public static void main( String[] args )
    {
        SpringApplication.run(App.class, args);
    }
    
    @Bean
    public CommandLineRunner loadData(CustomerService service) {
    	return(args) -> {
    		
    		service.addCustomer(new Customer("Sayali",98696804,"abc@b.com","29/10/1996","abc.xyz.jpg"));
    		service.addCustomer(new Customer("Ssaayali",986968041,"abc@b1.com","28/10/1996","abc.xyz1.jpg"));
    		service.addCustomer(new Customer("Sahyyali",986968043,"abc@b2.com","2/10/1996","abc.xyz2.jpg"));
    		service.addCustomer(new Customer("Sayali",986968044,"abc@b3.com","29/2/1996","abc.xyz3.jpg"));
    		service.addCustomer(new Customer("kjSayali",986968045,"abc@b4.com","26/10/1996","abc.xyz4.jpg"));
    		service.addCustomer(new Customer("S.layali",986968046,"abc@b5.com","25/10/1996","abc.xyz5.jpg"));
    		service.addCustomer(new Customer("Sa0yali",986968047,"abc@b6.com","24/10/1996","abc.xyz6.jpg"));
    		service.addCustomer(new Customer("Sayaloli",986968048,"abc@b7.com","23/10/1996","abc.xyz7.jpg"));
    		service.addCustomer(new Customer("Sayakili",986968049,"abc@b8.com","29/11/1996","abc.xyz8.jpg"));
    		service.addCustomer(new Customer("Sayjhali",98696804,"abc@b9.com","29/10/1986","abc.xyz9.jpg"));
    		service.addCustomer(new Customer("Sayadscvsli",98696803,"abc@b10.com","29/5/1996","abc.xyz10.jpg"));
    	};
    }
}
