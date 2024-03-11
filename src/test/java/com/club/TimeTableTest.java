package com.club;

import java.time.LocalDate;
import java.util.List;

import com.club.data.Timetable;

public class TimeTableTest {
    
    public static void main(String[] args) {
        Timetable generator = new Timetable();
        List<String> weekendtimes = generator.getTimings();
        List<String> weekendDays = generator.getNextWeekendDays();
        
        for (String day : weekendDays) {
            System.out.println(day);
        }
        for (String time : weekendtimes) {
            System.out.println(time);
        }
    }
}
