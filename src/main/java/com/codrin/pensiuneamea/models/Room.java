package com.codrin.pensiuneamea.models;

public class Room {
    public int roomID;

    public Room(int roomID, String name) {
        this.roomID = roomID;
        this.name = name;
    }

    public int getRoomID() {
        return roomID;
    }

    public String getName() {
        return name;
    }

    public String name;

}
