package com.smartbooking.core.application;

import com.smartbooking.core.domain.Booking;
import com.smartbooking.core.domain.BookingRepository;

import java.time.LocalDate;

public class BookingService {
    private final BookingRepository bookingRepository;
    private static final double PRICE_PER_NIGHT = 100.0;

    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    public Booking createBooking(String customer, LocalDate checkIn, LocalDate checkOut) {
        Booking booking = new Booking(customer, checkIn, checkOut);
        double price = booking.getNumberOfNights() * PRICE_PER_NIGHT;
        System.out.println("💰 Prix calculé = " + price + " €");
        return bookingRepository.save(booking);
    }
}
