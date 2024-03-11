package com.club.data;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class Timetable {
	
	public List<String> getNextWeekendDays() {
        List<String> weekendDaysList = new ArrayList<>();
        LocalDate startDate=LocalDate.now();
        int numOfDays = 20;
        while (weekendDaysList.size() < numOfDays) {
            if (startDate.getDayOfWeek() == DayOfWeek.SATURDAY || startDate.getDayOfWeek() == DayOfWeek.SUNDAY) {
                weekendDaysList.add(formatDate(startDate));
            }
            startDate = startDate.plusDays(1);
        }
        
        return weekendDaysList;
    }
    public List<String> getTimings()
    {
    	 List<String> weekendTimeList = new ArrayList<>();
    			 weekendTimeList.add("10:00 AM - 12:00 AM "+"(Tutor : Siavreddy)");
    			 weekendTimeList.add("01:00 PM - 03:00 PM "+"(Tutor : nikhil)");
    			 weekendTimeList.add("05:00 PM - 07:00 PM "+"(Tutor : prudhvi)");
    		
    	 return weekendTimeList;
    	 
    }
    private String formatDate(LocalDate date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy EEEE");
        return date.format(formatter);
    }
}
