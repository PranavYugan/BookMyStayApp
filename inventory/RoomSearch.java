package com.seveneleven.BookMyStayApp.inventory;
import java.util.Scanner;
public class RoomSearch {
    private RoomInventory inventory;

    public RoomSearch(RoomInventory inventory) {
        this.inventory = inventory;
    }

    public void displayAvailableRooms() {
        inventory.displayInventory();
    }

    public void searchRoom() {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter room type to search: ");
        String roomType = sc.nextLine();

        int availability = inventory.getAvailability(roomType);
        double price = inventory.getPrice(roomType);

        if (availability > 0) {
            System.out.println(roomType + " is available.");
            System.out.println("Count: " + availability + ", Price: " + price);
        } else {
            System.out.println(roomType + " is not available.");
        }
    }
}