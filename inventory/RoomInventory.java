package com.seveneleven.BookMyStayApp.inventory;

import java.util.HashMap;
public class RoomInventory {
    private HashMap<String, Integer> roomCounts = new HashMap<>();
    private HashMap<String, Double> roomPrices = new HashMap<>();

    public void initializeRooms() {
        addRoom("Single", 10, 2000.0);
        addRoom("Double", 5, 2500.0);
        addRoom("Suite", 2, 3000.0);
    }

    public void addRoom(String type, int count, double price) {
        roomCounts.put(type, count);
        roomPrices.put(type, price);
    }

    public void updateRoomCount(String type, int newCount) {
        roomCounts.put(type, newCount);
    }

    public void updateRoomPrice(String type, double newPrice) {
        roomPrices.put(type, newPrice);
    }

    public int getAvailability(String type) {
        return roomCounts.getOrDefault(type, 0);
    }

    public double getPrice(String type) {
        return roomPrices.getOrDefault(type, 0.0);
    }

    public void displayInventory() {
        System.out.println("Current Inventory:");
        for (String type : roomCounts.keySet()) {
            System.out.println(type + " - "  + roomPrices.get(type));
        }
    }
}