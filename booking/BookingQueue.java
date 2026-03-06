package com.seveneleven.BookMyStayApp.booking;
import com.seveneleven.BookMyStayApp.inventory.*;
import java.util.LinkedList;
import java.util.Queue;

public class BookingQueue {
    private Queue<Reservation> bookingQueue = new LinkedList<>();
    private RoomInventory inventory;

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
            int available = inventory.getAvailability(current.getRoomType());
            if (available > 0) {
                inventory.updateRoomCount(current.getRoomType(), available - 1);
                System.out.println("Confirmed for " + current.getGuestName());
            } 
            else {
                System.out.println("Failed for " + current.getGuestName() + " (not available)");
            }

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}