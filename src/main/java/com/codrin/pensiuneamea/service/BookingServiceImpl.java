package com.codrin.pensiuneamea.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codrin.pensiuneamea.models.Booking;
import com.codrin.pensiuneamea.repositories.BookingRepository;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Override
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    @Override
    public void saveBooking(Booking booking) {
        this.bookingRepository.save(booking);
    }

    @Override
    public Booking getBookingById(long id) {
        Optional < Booking > optional = bookingRepository.findById(id);
        Booking booking = null;
        if (optional.isPresent()) {
            booking = optional.get();
        } else {
            throw new RuntimeException(" Booking not found for id :: " + id);
        }
        return booking;
    }

    @Override
    public void deleteBookingById(long id) {
        this.bookingRepository.deleteById(id);
    }
}