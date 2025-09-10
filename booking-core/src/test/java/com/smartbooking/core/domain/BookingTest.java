package com.smartbooking.core.domain;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

class BookingTest {

    @Test
    void shouldCalculateNumberOfNightsCorrectly() {
        Booking booking = new Booking("Hosni",
                LocalDate.of(2025, 9, 15),
                LocalDate.of(2025, 9, 18));

        assertEquals(3, booking.getNumberOfNights());
    }

    @Test
    void shouldThrowExceptionIfCheckOutBeforeCheckIn() {
        assertThrows(IllegalArgumentException.class, () -> 
            new Booking("Hosni",
                    LocalDate.of(2025, 9, 20),
                    LocalDate.of(2025, 9, 18))
        );
    }
}
