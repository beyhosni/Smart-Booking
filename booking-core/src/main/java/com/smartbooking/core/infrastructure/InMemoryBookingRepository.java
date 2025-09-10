package com.smartbooking.core.infrastructure;

import com.smartbooking.core.domain.Booking;
import com.smartbooking.core.domain.BookingRepository;

import java.util.ArrayList;
import java.util.List;

public class InMemoryBookingRepository implements BookingRepository {
    private final List<Booking> bookings = new ArrayList<>();

    @Override
    public Booking save(Booking booking) {
        bookings.add(booking);
        return booking;
    }

    public List<Booking> findAll() {
        return bookings;
    }
}
