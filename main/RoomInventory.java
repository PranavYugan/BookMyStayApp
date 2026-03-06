package com.seveneleven.BookMyStayApp.main;
import java.util.*;
public class RoomInventory {

    private HashMap<String, Integer> roomCount = new HashMap<>();
    private HashMap<String, Double> roomPrice = new HashMap<>();
    
    public void initializeRooms() {
        addRoomType("Single", 10, 50.0);
        addRoomType("Double", 5, 90.0);
        addRoomType("Suite", 2, 200.0);
    }

    public void addRoomType(String roomType, int count, double price) {
        roomCount.put(roomType, count);
        roomPrice.put(roomType, price);
    }

    public void updateRoomCount(String roomType, int newCount) {
        roomCount.put(roomType, newCount);
    }

    public void updateRoomPrice(String roomType, double newPrice) {
        roomPrice.put(roomType, newPrice);
    }

    public int getAvailability(String roomType) {
        return roomCount.get(roomType);
    }

    public double getPrice(String roomType) {
        return roomPrice.get(roomType);
    }

    public static void main(String[] args) {
        RoomInventory inventory = new RoomInventory();
        inventory.initializeRooms();

        inventory.addRoomType("Deluxe", 3, 150.0);

        inventory.updateRoomCount("Single", 12);
        inventory.updateRoomPrice("Suite", 220.0);

        System.out.println("Single rooms available: " + inventory.getAvailability("Single"));
        System.out.println("Suite price per night: " + inventory.getPrice("Suite"));
        System.out.println("Deluxe rooms available: " + inventory.getAvailability("Deluxe"));
        System.out.println("Deluxe price per night: " + inventory.getPrice("Deluxe"));
    }
}