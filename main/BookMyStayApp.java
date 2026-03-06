package com.seveneleven.BookMyStayApp.main;

import java.util.Scanner;
import com.seveneleven.BookMyStayApp.inventory.*;
import com.seveneleven.BookMyStayApp.booking.*;
import com.seveneleven.BookMyStayApp.services.*;

public class BookMyStayApp {
    public static void main(String[] args) {
        RoomInventory inventory = new RoomInventory();
        inventory.initializeRooms();

        BookingQueue bookingService = new BookingQueue(inventory);
        ServiceManager serviceManager = new ServiceManager();

        Scanner sc = new Scanner(System.in);

        System.out.println("Current Inventory");
        inventory.displayInventory();

        RoomSearch searchService = new RoomSearch(inventory);
        searchService.searchRoom();

        System.out.print("Enter number of reservations to add: ");
        int n = Integer.parseInt(sc.nextLine());

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

        System.out.println("Attach services to reservations:");
        for (Reservation res : bookingService.getConfirmedReservations()) {
            System.out.println("\nGuest: " + res.getGuestName() + " | Room ID: " + res.getRoomId());
            while (true) {
                System.out.println("Choose service: 1) Breakfast ₹500  2) Spa ₹1500  3) Pickup ₹800  4) Done");
                String choice = sc.nextLine().trim();
                Service service = null;
                if (choice.equals("1")) service = new Service("Breakfast", 500);
                else if (choice.equals("2")) service = new Service("Spa", 1500);
                else if (choice.equals("3")) service = new Service("Pickup", 800);
                else if (choice.equals("4")) break;

                if (service != null) {
                    serviceManager.addService(res, service);
                }
            }
            serviceManager.showServices(res);
            double total = serviceManager.calculateTotalCost(res, inventory.getPrice(res.getRoomType()));
            System.out.println("Total cost for " + res.getGuestName() + ": " + total);
        }

        sc.close();
    }
}