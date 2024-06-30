package com.mzml.leavelog.Service;

import com.mzml.leavelog.DAO.CalendarDAO;
import com.mzml.leavelog.Entity.Calendar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
@Service
public class CalendarServiceImpl implements CalendarService{
    CalendarDAO calendarDAO;
    @Autowired
    public CalendarServiceImpl(CalendarDAO calendarDAO) {
        this.calendarDAO = calendarDAO;
    }
    @Override
    public List<Calendar> getCalendar() {
        return calendarDAO.findAll();
    }

    @Override
    public Calendar getCalendarById(int date, int month, int year) {
        int id=(year*10000)+(month*100)+date;
        System.out.println(id);
        System.out.println(calendarDAO.findById(id).get());
        return calendarDAO.findById(id).get();
    }


}
