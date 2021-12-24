package com.codrin.pensiuneamea.service;

import java.util.List;

import com.codrin.pensiuneamea.models.Booking;

public interface BookingService {

    List <Booking> getAllBookings();
    void saveBooking(Booking booking);
    Booking getBookingById(long id);
    void deleteBookingById(long id);

}
