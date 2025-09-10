package com.smartbooking.core.application;

import com.smartbooking.core.domain.Booking;
import com.smartbooking.core.infrastructure.InMemoryBookingRepository;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class BookingServiceTest {

    @Test
    void shouldCreateBookingSuccessfully() {
        InMemoryBookingRepository repository = new InMemoryBookingRepository();
        BookingService service = new BookingService(repository);

        Booking booking = service.createBooking("Hosni",
                LocalDate.of(2025, 9, 15),
                LocalDate.of(2025, 9, 17));

        assertNotNull(booking);
        assertEquals("Hosni", booking.getCustomerName());
        assertEquals(2, booking.getNumberOfNights());
        assertEquals(1, repository.findAll().size());
    }
}
