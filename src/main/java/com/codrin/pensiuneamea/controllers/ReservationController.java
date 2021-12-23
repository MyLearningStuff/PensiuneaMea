package com.codrin.pensiuneamea.controllers;

import com.codrin.pensiuneamea.models.Reservation;

import com.codrin.pensiuneamea.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@RestController
public class ReservationController {
    @Autowired
    private ReservationRepository reservationRepository;

    private ArrayList<Reservation> reservations;

    public ReservationController() {

        reservations = new ArrayList<>();
        reservations.add(new Reservation(1l, "0720234567","Camera 1", LocalDate.of(2021, 12, 15), LocalDate.of(2021, 12, 16), 2));
        reservations.add(new Reservation(2l, "0720234567","Camera 2", LocalDate.of(2021, 12, 15), LocalDate.of(2021, 12, 15), 2));
        reservations.add(new Reservation(3l, "0720234567","Camera 3", LocalDate.of(2021, 12, 15), LocalDate.of(2021, 12, 15), 2));
        reservations.add(new Reservation(4l, "0720234567","Camera 4", LocalDate.of(2021, 12, 15), LocalDate.of(2021, 12, 15), 2));
        reservations.add(new Reservation(5l, "0720234567","Camera 2", LocalDate.of(2021, 12, 15), LocalDate.of(2021, 12, 15), 2));
    }

    @GetMapping("/reservation")
    public Reservation reservation(@RequestParam() String resID) {
        return reservations.get(Integer.parseInt(resID));
    }

    @GetMapping("/reservations")
    public List<Reservation> reservations() {
        return reservationRepository.findAll();
    }

    @PostMapping("/reservation")
    public ResponseEntity postReservation(@RequestBody Reservation reservation) {
        if (reservation.getBegin_date().isAfter(LocalDate.now()) && reservation.getEnd_date().isAfter(reservation.getBegin_date())) {
            reservationRepository.save(reservation);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/reservation")
    public void deleteReservation(@RequestParam String resID) {
        for (Reservation reservation : reservations) {
            if (Integer.parseInt(resID) == reservation.getId()) {
                reservations.remove(reservation);
                return;
            }

        }
    }

}