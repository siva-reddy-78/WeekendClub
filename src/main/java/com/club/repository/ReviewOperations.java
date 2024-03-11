package com.club.repository;

import org.springframework.stereotype.Repository;

import com.club.data.Review;

@Repository
public interface ReviewOperations {
     Review save(Review review);
}
