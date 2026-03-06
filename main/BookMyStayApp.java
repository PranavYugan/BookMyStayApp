package com.seveneleven.BookMyStayApp.main;
import java.util.*;
import com.seveneleven.BookMyStayApp.inventory.*;
public class BookMyStayApp {
    public static void main(String[] args) {
        RoomInventory inventory = new RoomInventory();
        inventory.initializeRooms();

        inventory.updateRoomCount("Single", 12);
        inventory.updateRoomPrice("Suite", 4000.0);
        inventory.addRoom("Deluxe", 3, 3000.0);

        RoomSearch searchService = new RoomSearch(inventory);

        searchService.displayAvailableRooms();
        searchService.searchRoom();
    }
}