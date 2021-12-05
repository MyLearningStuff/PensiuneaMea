package com.codrin.pensiuneamea.models;

import java.util.Date;

public class Reservation {
    private long id;
    private String guestName;
    private String begin_date, end_date;
    private int state;

    public Reservation(long id, String guestName, String begin_date, String end_date, int state) {
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

    public String getBegin_date() {
        return begin_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public int getState() {
        return state;
    }
}