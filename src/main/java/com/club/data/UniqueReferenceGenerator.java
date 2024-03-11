package com.club.data;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class UniqueReferenceGenerator {
    
    // Method to generate unique reference number
    public static String generateReferenceNumber() {
        // Get current timestamp
        long timestamp = System.currentTimeMillis();
        
        // Generate random number
        Random random = new Random();
        int randomNumber = random.nextInt(10000); // Change 10000 to the desired range
        
        // Combine timestamp and random number to form the reference number
        String referenceNumber = "REF-" + timestamp + "-" + randomNumber;
        
        return referenceNumber;
    }
}
