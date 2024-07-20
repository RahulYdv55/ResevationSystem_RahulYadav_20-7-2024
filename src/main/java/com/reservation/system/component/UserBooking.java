package com.reservation.system.component;

import com.reservation.system.entity.Booking;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Component
public class UserBooking {
    List<Booking> bookingList=new ArrayList<>();
    Map<Integer , List<Booking>> userBookingBook=new HashMap<>();
}
