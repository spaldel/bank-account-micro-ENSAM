package com.example.customer_service;

import com.example.customer_service.entities.Customer;
import com.example.customer_service.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import java.util.List;

@EnableDiscoveryClient
@SpringBootApplication
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(CustomerRepository customerRepository){
		return  args -> {

			// first method
			Customer customer1= Customer.builder()
					.firstname("aaaaa")
					.lastname("AAAA")
					.mail("aaa@AA.com")
					.build();
        customerRepository.save(customer1);

			Customer customer2= Customer.builder()
					.firstname("bbbbb")
					.lastname("BBBB")
					.mail("bbb@AA.com")
					.build();
			customerRepository.save(customer2);

			//save list

			List<Customer> customers = List.of(
					Customer.builder()
							.firstname("cccc")
							.lastname("CCCC")
							.mail("cccc@AA.com")
							.build(),
					Customer.builder()
							.firstname("ddddd")
							.lastname("DDDD")
							.mail("ddd@AA.com")
							.build()
			);
			customerRepository.saveAll(customers);
		};
	}
}
