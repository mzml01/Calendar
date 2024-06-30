package com.mzml.leavelog.DAO;

import com.mzml.leavelog.Entity.Calendar;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface CalendarDAO extends JpaRepository<Calendar, Integer> {

}
