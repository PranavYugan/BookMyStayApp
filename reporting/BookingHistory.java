package com.seveneleven.BookMyStayApp.reporting;

import java.util.ArrayList;
import java.util.List;
import com.seveneleven.BookMyStayApp.booking.Reservation;

public class BookingHistory {
    private List<Reservation> history;

    public BookingHistory() {
        history = new ArrayList<>();
    }

    public void addReservation(Reservation res) {
        history.add(res);
    }

    public void cancelReservation(Reservation res) {
        history.remove(res);
    }

    public List<Reservation> getHistory() {
        return history;
    }

    public void displayHistory() {
        System.out.println("Booking History");
        for (Reservation res : history) {
            System.out.println("Guest: " + res.getGuestName() + "  Room ID: " + res.getRoomId() + "  Room Type: " + res.getRoomType());
        }
    }
}