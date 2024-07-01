package com.mzml.leavelog.Service;

import com.mzml.leavelog.DAO.CalendarDAO;
import com.mzml.leavelog.Entity.Calendar;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CalendarServiceImpl implements CalendarService{
    EntityManager entityManager;
    CalendarDAO calendarDAO;
    @Autowired
    public CalendarServiceImpl(CalendarDAO calendarDAO,EntityManager entityManager){
        this.calendarDAO = calendarDAO;
        this.entityManager=entityManager;
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

    @Override
    public Calendar updateCalendar(int date,int month,int year) {
        return null;
    }
    @Transactional
    @Override
    public void update(Calendar calendar) {
        System.out.println(calendar);
        calendarDAO.save(calendar);
        System.out.println(calendar);
    }



}
