package com.seveneleven.BookMyStayApp.booking;

import com.seveneleven.BookMyStayApp.inventory.RoomInventory;
import java.util.*;

public class BookingQueue {
    private Queue<Reservation> bookingQueue = new LinkedList<>();
    private RoomInventory inventory;
    private List<Reservation> confirmedReservations = new ArrayList<>();
    private int roomCounter = 1;

    public BookingQueue(RoomInventory inventory) {
        this.inventory = inventory;
    }

    public void addBookingRequest(Reservation reservation) {
        bookingQueue.add(reservation);
        System.out.println("Request added: " + reservation);
    }

    public void processBookings() {
        while (!bookingQueue.isEmpty()) {
            Reservation current = bookingQueue.poll();
            System.out.println("Processing " + current);

            int available = inventory.getAvailability(current.getRoomType());
            if (available > 0) {
                String roomId = generateRoomId(current.getRoomType());
                current.assignRoomId(roomId);

                inventory.updateRoomCount(current.getRoomType(), available - 1);
                confirmedReservations.add(current);

                System.out.println("Confirmed for " + current.getGuestName() + " Room ID: " + roomId);
            } else {
                System.out.println("Failed for " + current.getGuestName() + " (not available)");
            }
        }
    }

    private String generateRoomId(String roomType) {
        return roomType.substring(0, 2).toUpperCase() + "-" + roomCounter++;
    }

    public List<Reservation> getConfirmedReservations() {
        return confirmedReservations;
    }
}