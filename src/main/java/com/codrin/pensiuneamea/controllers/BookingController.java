package com.codrin.pensiuneamea.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.codrin.pensiuneamea.models.Booking;
import com.codrin.pensiuneamea.service.BookingService;



@Controller
public class BookingController {

    @Autowired
    private BookingService bookingService;

    // display list of bookings
    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("listBookings", bookingService.getAllBookings());
        return "index";
    }

    @GetMapping("/showNewBookingForm")
    public String showNewBookingForm(Model model) {
        // create model attribute to bind form data
        Booking booking = new Booking();
        model.addAttribute("booking", booking);
        return "new_booking";
    }

    @PostMapping("/saveBooking")
    public String saveBooking(@ModelAttribute("booking") Booking booking) {
        // save booking to database
        bookingService.saveBooking(booking);
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {

        // get booking from the service
        Booking booking = bookingService.getBookingById(id);

        // set booking as a model attribute to pre-populate the form
        model.addAttribute("booking", booking);
        return "update_booking";
    }

    @GetMapping("/deleteBooking/{id}")
    public String deleteBooking(@PathVariable(value = "id") long id) {

        // call delete booking method
        this.bookingService.deleteBookingById(id);
        return "redirect:/";
    }
}