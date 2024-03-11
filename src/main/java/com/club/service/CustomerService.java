package com.club.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.club.data.Customer;
import com.club.repository.CustomerOperations;
import com.club.repository.CustomerRepository;

@Service
public class CustomerService implements CustomerOperations{

	@Autowired
	private CustomerRepository customerrepo;
	@Override
	public Customer save(Customer customer) {
		return customerrepo.save(customer);
	}
	@Override
	public Optional<Customer> details(Long id) {
		Optional<Customer> customer = customerrepo.findById(id);
		return customer;
	}
	@Override
	public Customer findByBookingid(String bookingid) {
		Customer existingcustomer=customerrepo.findByBookingid(bookingid);
		return existingcustomer;
	}
	
	
}
