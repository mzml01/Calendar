package com.mzml.leavelog.Entity;

import jakarta.persistence.*;
import org.springframework.http.converter.json.GsonBuilderUtils;

import java.time.LocalDate;

@Entity
@Table(name = "academiccalendar")
public class Calendar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "day")
    private String day;
    @Column(name = "date")
    private LocalDate date;
    @Column(name = "particulars")
    private String event;
    @Column(name = "orderoftheday")
    private String orderOfTheDay;

    public Calendar(String day, LocalDate date, String event, String dayOrder) {
        this.day = day;
        this.date = date;
        this.event = event;
        this.orderOfTheDay = dayOrder;
    }

    public Calendar() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getDayOrder() {
        return orderOfTheDay;
    }

    public void setDayOrder(String dayOrder) {
        this.orderOfTheDay = dayOrder;
    }

    @Override
    public String toString() {
        return "Calendar{" +
                "id=" + id +
                ", day='" + day + '\'' +
                ", date=" + date +
                ", event='" + event + '\'' +
                ", dayOrder='" + orderOfTheDay + '\'' +
                '}';
    }
}
