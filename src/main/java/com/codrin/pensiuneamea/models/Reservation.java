package com.codrin.pensiuneamea.models;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "reservation")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 15)
    private String phoneNumber;

    @Column(nullable = false, length = 45)
    private String guestName;

    @Column(nullable = false)
    private LocalDate begin_date;

    @Column(nullable = false)
    private LocalDate end_date;

    @Column(nullable = false)
    private int state;

    public Reservation() {

    }

    public Reservation(Long id, String phoneNumber, String guestName, LocalDate begin_date, LocalDate end_date, int state) {
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.guestName = guestName;
        this.begin_date = begin_date;
        this.end_date = end_date;
        this.state = state;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Long getId() {
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

    public void setId(Long id) {
        this.id = id;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public void setBegin_date(LocalDate begin_date) {
        this.begin_date = begin_date;
    }

    public void setEnd_date(LocalDate end_date) {
        this.end_date = end_date;
    }

    public void setState(int state) {
        this.state = state;
    }
}