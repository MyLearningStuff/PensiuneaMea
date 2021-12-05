package com.codrin.pensiuneamea.controllers;

import com.codrin.pensiuneamea.models.Reservation;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;


@RestController
public class ReservationController {
    private ArrayList<Reservation> reservations;

    public ReservationController() {

        reservations = new ArrayList<>();
        reservations.add(new Reservation(000, "N/A", "N/A", "N/A", 0));
        reservations.add(new Reservation(001, "Camera 1", "01/11/12", "02/11/12", 2));
        reservations.add(new Reservation(002, "Camera 2", "01/11/12", "02/11/12", 2));
        reservations.add(new Reservation(003, "Camera 3", "01/11/12", "02/11/12", 2));
        reservations.add(new Reservation(004, "Camera 4", "01/11/12", "02/11/12", 2));
        reservations.add(new Reservation(005, "Camera 2", "01/10/12", "02/10/12", 2));
    }

    @GetMapping("/reservation")
    public Reservation reservation(@RequestParam(defaultValue = "000") String resID) {
        return reservations.get(Integer.parseInt(resID));

    }
}