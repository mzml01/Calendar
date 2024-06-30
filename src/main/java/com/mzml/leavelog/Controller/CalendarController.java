package com.mzml.leavelog.Controller;

import com.mzml.leavelog.Entity.Calendar;
import com.mzml.leavelog.Service.CalendarServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/LeaveLog")
public class CalendarController {
    CalendarServiceImpl calendarService;
    @Autowired
    public CalendarController(CalendarServiceImpl calendarService) {
        this.calendarService = calendarService;
    }
    @GetMapping("/calendar")
    public String getCalendar(Model theModel){
        List<Calendar> calendar =calendarService.getCalendar() ;
        theModel.addAttribute("calendar", calendar);
        return "calendar-list";
    }
    @PostMapping("/day")
    public String getCalendarById(@RequestParam("date") int date,@RequestParam("month") int month,@RequestParam("year") int year ,Model theModel){
        Calendar calendar = calendarService.getCalendarById(date,month,year);
        theModel.addAttribute("calendar",calendar);
        return "calendar-details";
    }

}
