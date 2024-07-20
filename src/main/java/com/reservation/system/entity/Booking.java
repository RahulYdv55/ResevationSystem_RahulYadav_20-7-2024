package com.reservation.system.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Booking {

    String bookingId = String.valueOf(UUID.randomUUID());
    int userId;
    int totalSeatBooked;
    int amount;
    boolean paid=false;
}
