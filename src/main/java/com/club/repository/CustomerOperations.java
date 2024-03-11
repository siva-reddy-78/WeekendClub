package com.club.repository;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.club.data.Customer;

@Repository
public interface CustomerOperations {
	Customer save(Customer customer);
	Optional<Customer> details(Long id);
	Customer findByBookingid(String bookingid);
}
