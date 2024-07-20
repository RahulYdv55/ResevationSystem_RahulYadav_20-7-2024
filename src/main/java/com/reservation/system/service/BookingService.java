package com.reservation.system.service;

import com.reservation.system.Exception.InvalidBusId;
import com.reservation.system.Exception.SeatNotAvailable;
import com.reservation.system.component.SearchBusComponent;
import com.reservation.system.component.UserBooking;
import com.reservation.system.component.UserManagement;
import com.reservation.system.entity.Booking;
import com.reservation.system.entity.Bus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Service
public class BookingService {

    @Autowired
    @Qualifier("withData")
    private SearchBusComponent searchBusComponent;

    @Autowired
    private UserManagement userManagement;

    @Autowired
    private UserBooking userBooking;

    @Autowired
    private Payment payment;

    public String book(int userId,int busId,int totalSeatToBook) throws SeatNotAvailable, InvalidBusId {
        Bus bus=null;
        for(Bus b:searchBusComponent.getBusList()){
            if(b.getBusId()==busId) {
                bus = b;
                break;
            }
        }

        if(!searchBusComponent.getMp().containsKey(busId))
            throw new InvalidBusId("No bus exist with provided bus id");
        if(searchBusComponent.getMp().containsKey(busId)  && bus.getTotalSeat()-searchBusComponent.getMp().get(busId)>=totalSeatToBook){
            searchBusComponent.getMp().put(busId,searchBusComponent.getMp().get(busId)+totalSeatToBook);
            Booking booking= Booking.builder()
                    .bookingId(String.valueOf(UUID.randomUUID()))
                    .totalSeatBooked(totalSeatToBook)
                    .userId(userId)
                    .paid(true)
                    .amount(totalSeatToBook*100)
                    .build();

            userBooking.getBookingList().add(booking);
            List<Booking> bookingList=userBooking.getUserBookingBook().get(userId);
            if(bookingList==null){
                bookingList=new ArrayList<>();
                bookingList.add(booking);
            }else
                bookingList.add(booking);
            userBooking.getUserBookingBook().put(userId,bookingList);
            payment=new UPI();
            if(payment.pay())
                return "Seat Booked successfully";

        }
        else
            throw new SeatNotAvailable("Seat not available for given seats");

        return null;

    }
}
