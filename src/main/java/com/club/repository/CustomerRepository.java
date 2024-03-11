package com.club.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.club.data.Customer;

import jakarta.transaction.Transactional;

public interface CustomerRepository extends JpaRepository<Customer,Long>{
	
	Customer findByBookingid(String bookingid);
}
