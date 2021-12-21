package com.codrin.pensiuneamea.models;

import java.time.LocalDate;
import java.util.Date;

public class Reservation {
    private long id;
    private String guestName;
    private LocalDate begin_date;
    private LocalDate end_date;
    private int state;

    public Reservation(long id, String guestName, LocalDate begin_date, LocalDate end_date, int state) {
        this.id = id;
        this.guestName = guestName;
        this.begin_date = begin_date;
        this.end_date = end_date;
        this.state = state;
    }

    public long getId() {
        return id;
    }

    public String getGuestName() {
        return guestName;
    }

    public LocalDate getBegin_date() {
        return begin_date;
    }

    public LocalDate getEnd_date() {
        return end_date;
    }

    public int getState() {
        return state;
    }
}