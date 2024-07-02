package com.mzml.leavelog.Controller;

import com.mzml.leavelog.DTO.CalendarForm;
import com.mzml.leavelog.DTO.CalendarSchedule;
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
    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(Model theModel){
        CalendarForm calendarForm = new CalendarForm();
        theModel.addAttribute("calendarForm", calendarForm);
        return "update-form";
    }
    @PostMapping("/update")
    public String updateForm(@Valid @ModelAttribute("calendarForm") CalendarForm calendarForm,
                             BindingResult bindingResult, Model theModel){
        if (bindingResult.hasErrors()) {
            return "update-form";
        }
        try {
            int date = Integer.parseInt(calendarForm.getDate());
            int month = Integer.parseInt(calendarForm.getMonth());
            int year = Integer.parseInt(calendarForm.getYear());

            Calendar calendar = calendarService.getCalendarById(date, month, year);
            theModel.addAttribute("calendar", calendar);
            return "update-details";
        } catch (NumberFormatException e) {
            theModel.addAttribute("errorMessage", "Date, month, and year must be integers.");
            return "update-form";
        }
    }
    @PostMapping("/save")
    public String saveForm(@ModelAttribute("calendar") Calendar calendar,Model theModel){
        calendarService.update(calendar);
        return "redirect:/LeaveLog/calendar";
    }
    @GetMapping("/showFormForSchedule")
    public String showFormForSchedule(Model theModel){
        CalendarSchedule calendarSchedule = new CalendarSchedule();
        theModel.addAttribute("calendarSchedule", calendarSchedule);
        return "schedule-form";
    }
    @PostMapping("/scheduleDetails")
    public String scheduleDetails(@ModelAttribute("calendarForm") CalendarSchedule calendarForm,
                                  Model theModel){
            int startDate = Integer.parseInt(calendarForm.getStartDate());
            int endDate = Integer.parseInt(calendarForm.getEndDate());
            int startMonth = Integer.parseInt(calendarForm.getStartMonth());
            int startYear = Integer.parseInt(calendarForm.getStartYear());


            List<Calendar> calendars = calendarService.getCalendarSpans(startDate, endDate, startMonth, startYear);
            theModel.addAttribute("calendar2", calendars);
            return "schedule-details";

    }

}
