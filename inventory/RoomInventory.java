package com.seveneleven.BookMyStayApp.inventory;

import java.util.HashMap;

public class RoomInventory {
    private HashMap<String, Integer> roomCounts = new HashMap<>();
    private HashMap<String, Double> roomPrices = new HashMap<>();

    public void initializeRooms() {
        addRoom("Single", 10, 2000.0);
        addRoom("Double", 5, 2500.0);
        addRoom("Suite", 2, 3000.0);
        addRoom("Deluxe", 3, 3000.0);
    }

    public void addRoom(String type, int count, double price) {
        roomCounts.put(type.toLowerCase(), count);
        roomPrices.put(type.toLowerCase(), price);
    }

    public void updateRoomCount(String type, int newCount) {
        roomCounts.put(type.toLowerCase(), newCount);
    }

    public void updateRoomPrice(String type, double newPrice) {
        roomPrices.put(type.toLowerCase(), newPrice);
    }

    public int getAvailability(String type) {
        return roomCounts.getOrDefault(type.toLowerCase(), 0);
    }

    public double getPrice(String type) {
        return roomPrices.getOrDefault(type.toLowerCase(), 0.0);
    }

    public void displayInventory() {
        System.out.println("Available rooms:");
        for (String type : roomCounts.keySet()) {
            System.out.println(capitalize(type) + " - " + roomCounts.get(type) +
                               " - " + roomPrices.get(type));
        }
    }

    private String capitalize(String s) {
        return s.substring(0,1).toUpperCase() + s.substring(1);
    }
}