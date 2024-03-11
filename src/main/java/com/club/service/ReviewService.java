package com.club.service;

import org.springframework.stereotype.Service;

import com.club.data.Review;
import com.club.repository.ReviewOperations;
import com.club.repository.ReviewRepository;

@Service
public class ReviewService implements ReviewOperations{

	private ReviewRepository reviewrepo;
	
	public ReviewService(ReviewRepository reviewrepo) {
		super();
		this.reviewrepo = reviewrepo;
	}

	@Override
	public Review save(Review review) {
		return reviewrepo.save(review);
	}

}
