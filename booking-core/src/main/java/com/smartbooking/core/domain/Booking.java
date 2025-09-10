package com.smartbooking.core.domain;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Booking {
    private final String customerName;
    private final LocalDate checkIn;
    private final LocalDate checkOut;

    public Booking(String customerName, LocalDate checkIn, LocalDate checkOut) {
        if (checkOut.isBefore(checkIn)) {
            throw new IllegalArgumentException("Check-out date cannot be before check-in date");
        }
        this.customerName = customerName;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public long getNumberOfNights() {
        return ChronoUnit.DAYS.between(checkIn, checkOut);
    }

    public String getCustomerName() {
        return customerName;
    }

    public LocalDate getCheckIn() {
        return checkIn;
    }

    public LocalDate getCheckOut() {
        return checkOut;
    }
}
