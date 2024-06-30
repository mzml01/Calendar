package com.mzml.leavelog.Controller;

import com.mzml.leavelog.DTO.CalendarForm;
import com.mzml.leavelog.Entity.Calendar;
import com.mzml.leavelog.Service.CalendarServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
        CalendarForm calendarForm = new CalendarForm();
        theModel.addAttribute("calendar", calendar);
        theModel.addAttribute("calendarForm", calendarForm);
        return "calendar-list";
    }
    @PostMapping("/day")
    public String getCalendarById(@Valid @ModelAttribute("calendarForm") CalendarForm calendarForm,
                                  BindingResult bindingResult, Model theModel) {
        if (bindingResult.hasErrors()) {
            return "calendar-list";
        }

        try {
            int date = Integer.parseInt(calendarForm.getDate());
            int month = Integer.parseInt(calendarForm.getMonth());
            int year = Integer.parseInt(calendarForm.getYear());

            Calendar calendar = calendarService.getCalendarById(date, month, year);
            theModel.addAttribute("calendar", calendar);
            return "calendar-details";
        } catch (NumberFormatException e) {
            theModel.addAttribute("errorMessage", "Date, month, and year must be integers.");
            return "calendar-list";
        }
    }

}
