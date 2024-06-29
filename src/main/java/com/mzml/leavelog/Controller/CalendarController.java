package com.mzml.leavelog.Controller;

import com.mzml.leavelog.Entity.Calendar;
import com.mzml.leavelog.Service.CalendarServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/LeaveLog")
public class CalendarController {
    CalendarServiceImpl calendarService;
    @Autowired
    public CalendarController(CalendarServiceImpl calendarService) {
        this.calendarService = calendarService;
    }
    @GetMapping()
    public List<Calendar> getCalendar(){
        return calendarService.getCalendar();
    }
//    @GetMapping("/{date}")
//    public Calendar getEvent(@RequestParam("date") LocalDate date){
//        return calendarService.getEvent(date);
//    }
}
