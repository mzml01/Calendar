package com.mzml.leavelog.Service;

import com.mzml.leavelog.Entity.Calendar;

import java.util.List;

public interface CalendarService {
    public List<Calendar> getCalendar();
    public Calendar getCalendarById(int date,int month,int year);
    public void update(Calendar calendar);
    public List<Calendar> getCalendarSpans(int startDate, int endDate, int startMonth, int startYear);
}
