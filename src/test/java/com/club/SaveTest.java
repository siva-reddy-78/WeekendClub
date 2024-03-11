package com.club;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.club.data.Customer;
import com.club.service.CustomerService;

@SpringBootTest
class SaveTest {

	@Autowired
	private CustomerService cservice;

	@Test
    void testSaveCustomer() {
        // Create a mock customer object
        Customer customer = new Customer();
        customer.setFirstname("John");
        customer.setLastname("Doe");
        customer.setDob(LocalDate.of(1990, 5, 15));
        customer.setMobilenumber("1234567890");
        customer.setBookingid("123abc");
        Customer savedCustomer = cservice.save(customer);
        System.out.println(savedCustomer.toString());
	}

}
