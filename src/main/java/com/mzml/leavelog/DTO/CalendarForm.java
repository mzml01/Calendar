package com.mzml.leavelog.DTO;


import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class CalendarForm {
    @NotNull(message = "Date cannot be null")
    @Pattern(regexp = "\\d+", message = "Date must be a number")
    private String date;

    @NotNull(message = "Month cannot be null")
    @Pattern(regexp = "\\d+", message = "Month must be a number")
    @Min(value = 6, message = "Month must be between 6 and 11")
    @Max(value = 11, message = "Month must be between 6 and 11")
    private String month;

    @NotNull(message = "Year cannot be null")
    @Pattern(regexp = "\\d+", message = "Year must be a number")
    @Min(value = 2024, message = "Year must be 2024 , just 1 sem data available")
    @Max(value = 2024, message = "Year must be 2024 , just 1 sem data available")
    private String year;

    // Getters and setters
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
