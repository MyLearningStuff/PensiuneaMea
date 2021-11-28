package com.codrin.pensiuneamea.controllers;

import com.codrin.pensiuneamea.models.Room;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController

public class RoomController {
    private ArrayList<Room> rooms;

    public RoomController(){

        rooms = new ArrayList<>();
        rooms.add(new Room(1, "Camera 1"));
        rooms.add(new Room(2, "Camera 2"));
        rooms.add(new Room(3, "Camera 3"));
        rooms.add(new Room(4, "Camera 4"));
        rooms.add(new Room(5, "Camera 5"));
    }
    @GetMapping("/allrooms")
    public ArrayList<Room> getAllRooms() {
        return rooms;
    }
}
