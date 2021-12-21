package com.codrin.pensiuneamea.controllers;

import com.codrin.pensiuneamea.models.Reservation;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;


@RestController
public class ReservationController {
    private ArrayList<Reservation> reservations;

    public ReservationController() {

        reservations = new ArrayList<>();
        reservations.add(new Reservation(001, "Camera 1", LocalDate.of(2021, 12, 15), LocalDate.of(2021, 12, 16), 2));
        reservations.add(new Reservation(002, "Camera 2", LocalDate.of(2021, 12, 15), LocalDate.of(2021, 12, 15), 2));
        reservations.add(new Reservation(003, "Camera 3", LocalDate.of(2021, 12, 15), LocalDate.of(2021, 12, 15), 2));
        reservations.add(new Reservation(004, "Camera 4", LocalDate.of(2021, 12, 15), LocalDate.of(2021, 12, 15), 2));
        reservations.add(new Reservation(005, "Camera 2", LocalDate.of(2021, 12, 15), LocalDate.of(2021, 12, 15), 2));
    }

    @GetMapping("/reservation")
    public Reservation reservation(@RequestParam(defaultValue = "000") String resID) {
        return reservations.get(Integer.parseInt(resID));
    }

    @GetMapping("/reservations")
    public ArrayList<Reservation> reservations() {
        return reservations;
    }

    @PostMapping("/reservation")
    public ResponseEntity postReservation(@RequestBody Reservation reservation) {
        if (reservation.getBegin_date().isAfter(LocalDate.now()) && reservation.getEnd_date().isAfter(reservation.getBegin_date())) {
            reservations.add(reservation);
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