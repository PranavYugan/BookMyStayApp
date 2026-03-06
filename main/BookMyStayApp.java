package com.seveneleven.BookMyStayApp.main;

import java.util.Scanner;
import com.seveneleven.BookMyStayApp.inventory.*;
import com.seveneleven.BookMyStayApp.booking.*;

public class BookMyStayApp {
    public static void main(String[] args) {
        RoomInventory inventory = new RoomInventory();
        inventory.initializeRooms();

        inventory.updateRoomCount("Single", 12);
        inventory.updateRoomPrice("Suite", 4000.0);
        inventory.addRoom("Deluxe", 3, 3000.0);

        RoomSearch searchService = new RoomSearch(inventory);

        System.out.println("Current Inventory");
        searchService.displayAvailableRooms();

        searchService.searchRoom();

        BookingQueue bookingService = new BookingQueue(inventory);

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of reservations to add:");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter guest name: ");
            String guestName = sc.nextLine();
            System.out.print("Enter room type: ");
            String roomType = sc.nextLine();
            bookingService.addBookingRequest(new Reservation(guestName, roomType));
        }

        System.out.println("Inventory Before Processing");
        inventory.displayInventory();

        System.out.println("Processing Bookings");
        bookingService.processBookings();

        System.out.println("Inventory After Processing");
        inventory.displayInventory();
    }
}