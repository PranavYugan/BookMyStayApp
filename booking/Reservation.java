package com.seveneleven.BookMyStayApp.booking;

public class Reservation {
    private String guestName;
    private String roomType;
    private String roomId;

    public Reservation(String guestName, String roomType) {
        this.guestName = guestName;
        this.roomType = roomType;
    }

    public String getGuestName() {
        return guestName;
    }

    public String getRoomType() {
        return roomType;
    }

    public String getRoomId() {
        return roomId;
    }

    public void assignRoomId(String roomId) {
        this.roomId = roomId;
    }

    @Override
    public String toString() {
        return "Guest=" + guestName + ", RoomType=" + roomType +
               (roomId != null ? ", RoomID=" + roomId : "") + "]";
    }
}