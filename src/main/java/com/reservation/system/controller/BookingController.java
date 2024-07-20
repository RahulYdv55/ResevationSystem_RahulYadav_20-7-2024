package com.reservation.system.controller;


import com.reservation.system.Exception.InvalidBusId;
import com.reservation.system.Exception.SeatNotAvailable;
import com.reservation.system.component.UserBooking;
import com.reservation.system.component.UserManagement;
import com.reservation.system.entity.Booking;
import com.reservation.system.service.BookingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/API/Booking")
@Slf4j
public class BookingController {


    @Autowired
    private BookingService bookingService;

    @Autowired
    private UserBooking userBooking;


    @PostMapping("/book")
    public ResponseEntity<?> bookSeat(@RequestParam int userId,@RequestParam int busId,@RequestParam int totalSeatToBook){
        try {
            return ResponseEntity.ok().body(bookingService.book(userId,busId,totalSeatToBook));
        }catch (SeatNotAvailable ex){
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No seat available for given bus");
        } catch (InvalidBusId e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid bus id");
        }


    }

    @GetMapping("/all/booking")
    public ResponseEntity<?> getBooking(){
        List<Booking> bookingList = userBooking.getBookingList();
        if(bookingList.size()>0)
            return ResponseEntity.ok().body(bookingList);
        else
            return ResponseEntity.ok().body("No booking till now");
    }

    @GetMapping("/all/user")
    public ResponseEntity<?> getBookingWithId(@RequestParam  int userId){
        List<Booking> bookingList= userBooking.getUserBookingBook().get(userId);
        if(bookingList.size()>0)
            return ResponseEntity.ok().body(bookingList);
        else
        {
            return ResponseEntity.ok().body("User have not done any booking");
        }

    }


}
