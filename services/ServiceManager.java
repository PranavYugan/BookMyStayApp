package com.seveneleven.BookMyStayApp.services;

import java.util.*;

import com.seveneleven.BookMyStayApp.booking.Reservation;

public class ServiceManager {
    private Map<String, List<Service>> reservationServices = new HashMap<>();

    public void addService(Reservation reservation, Service service) {
        reservationServices
            .computeIfAbsent(reservation.getRoomId(), k -> new ArrayList<>())
            .add(service);
        System.out.println("Added " + service + " to " + reservation);
    }

    public double calculateTotalCost(Reservation reservation, double basePrice) {
        List<Service> services = reservationServices.getOrDefault(reservation.getRoomId(), new ArrayList<>());
        double extra = services.stream().mapToDouble(Service::getPrice).sum();
        return basePrice + extra;
    }

    public void showServices(Reservation reservation) {
        List<Service> services = reservationServices.getOrDefault(reservation.getRoomId(), new ArrayList<>());
        if (services.isEmpty()) {
            System.out.println("No add‑on services for " + reservation);
        } else {
            System.out.println("Services for " + reservation + ": " + services);
        }
    }
}