package com.mzml.leavelog.DTO;

public class CalendarSchedule {
    private String startDate;
    private String endDate;
    private String startYear;
    private String startMonth;

    public CalendarSchedule() {
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getStartYear() {
        return startYear;
    }

    public void setStartYear(String startYear) {
        this.startYear = startYear;
    }



    public String getStartMonth() {
        return startMonth;
    }

    public void setStartMonth(String startMonth) {
        this.startMonth = startMonth;
    }


    @Override
    public String toString() {
        return "CalendarSchedule{" +
                "startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", startYear='" + startYear + '\'' +
                ", startMonth='" + startMonth + '\'' +
                '}';
    }
}
