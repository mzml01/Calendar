package com.mzml.leavelog.Service;

import com.mzml.leavelog.Entity.Calendar;

import java.time.LocalDate;
import java.util.List;

public interface CalendarService {
    public List<Calendar> getCalendar();
//    public Calendar getEvent(LocalDate date);
}
