package com.club.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.club.data.Customer;
import com.club.data.Review;
import com.club.service.CustomerService;
import com.club.service.ReviewService;


@Controller
public class ReviewController {
    private ReviewService reviewService;
    private CustomerService customerService;

    public ReviewController(ReviewService reviewService, CustomerService customerService) {
		super();
		this.reviewService = reviewService;
		this.customerService = customerService;
    }
    @GetMapping("review")
    public String review()
    {
    	return "review";
    }

    @GetMapping("/review/{bookingid}")
    public String reviewForm(Model model,Customer customer,Review review,
                             @PathVariable("bookingid") String bookingid) {
        model.addAttribute("review", review); 
        return "reviewForm"; 
    }

    @PostMapping("/submitReview")
    public String submitReview(@ModelAttribute Review review,
    		                   Model model,@RequestParam("bookingid") String bookingid) {
    	    Customer customer=customerService.findByBookingid(bookingid);
    	    review.setCustomer(customer);
    	
            Review savedReview = reviewService.save(review); // Save the review
            model.addAttribute("savedReview", savedReview); // Add the saved review to the model
            return "review"; // Return a confirmation view
    } 
}

