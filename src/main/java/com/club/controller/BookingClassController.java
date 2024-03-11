package com.club.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.club.data.Customer;
import com.club.data.Timetable;
import com.club.data.UniqueReferenceGenerator;
import com.club.service.CustomerService;

@Controller
public class BookingClassController {
  
	private CustomerService customerservice;
	public BookingClassController(CustomerService customerservice) {
		super();
		this.customerservice = customerservice;
	}
	@GetMapping("/reg")
	public String registration(Model model)
	{
		System.out.println("i'm reg controller");
		
		Customer customer = new Customer();
		model.addAttribute("customer" , customer);
		
		Timetable timetable= new Timetable(); 
		List<String> weekendDays = timetable.getNextWeekendDays();
		List<String> weekendTime = timetable.getTimings();
		model.addAttribute("weekendTime", weekendTime);
		model.addAttribute("weekendDays",weekendDays);
		
		return "booking";
	}
	@PostMapping("/submitBooking")
	public String formSubmission(@ModelAttribute("customer") Customer customer , RedirectAttributes ra)
	{
	    customer.setStatus("booked");
	    UniqueReferenceGenerator uniqueRef = new UniqueReferenceGenerator();
	    ra.addFlashAttribute("message", "The class has been booked successfully");
	    String bid = uniqueRef.generateReferenceNumber();
	    if(customer.getBookingid().isEmpty())
	    {
	      customer.setBookingid(customer.getFirstname().substring(0, 2)+bid);
	    }
	    else 
	    {
	    	customer.setBookingid(customer.getBookingid());
	    }
	    Customer savedCustomer = customerservice.save(customer);
	    return "redirect:submitBooking/details/" + savedCustomer.getBookingid();
	}
	
	@GetMapping("/submitBooking/details/{bookingid}")
	public String details(@PathVariable("bookingid") String bookingid, Model model) {
	    Customer bookedUser = customerservice.findByBookingid(bookingid);
	    model.addAttribute("bookedUser", bookedUser);
	    return "bookingdetails";
	}
	@GetMapping("/submit/update/{bookingid}")
	public String update(@PathVariable("bookingid") String bookingid , Model model)
	{
		Customer customer=customerservice.findByBookingid(bookingid);
		model.addAttribute("customer", customer);
		Timetable timetable= new Timetable(); 
		List<String> weekendDays = timetable.getNextWeekendDays();
		List<String> weekendTime = timetable.getTimings();
		model.addAttribute("weekendTime", weekendTime);
		model.addAttribute("weekendDays",weekendDays);
		
		return "booking";
	}
	@GetMapping("/manage")
	public String manage(Model model)
	{
		return "manage";
	}
	@GetMapping("/view")
	public String view(Model model)
	{
		return "view";
	}
 
}
