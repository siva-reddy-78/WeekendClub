package com.club.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.club.data.Review;

public interface ReviewRepository extends JpaRepository<Review , Long> {
	
}
