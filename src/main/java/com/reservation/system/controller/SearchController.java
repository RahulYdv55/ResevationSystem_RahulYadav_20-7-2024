package com.reservation.system.controller;


import com.reservation.system.Exception.InvalidBusId;
import com.reservation.system.dto.BusDto;
import com.reservation.system.service.BusService;
import com.reservation.system.config.InItConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Slf4j
public class SearchController {

    @Autowired
    private BusService busService;


    @Autowired
    private InItConfig inItService;

    @GetMapping("/search")
    public ResponseEntity<?> getBusBasedOnFromAndTo(@RequestParam String from, @RequestParam String to){
        log.info("Searching bus from {} : to {}",from,to);

      //  inItService.intialise();

        List<BusDto> busDtoList = busService.searchBus(from,to);

        if(busDtoList.size()>0){
            return ResponseEntity.ok().body(busDtoList);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No Bus available for given route");
        }
    }

    @GetMapping("/empty/seat")
    public ResponseEntity<?> getTotalSeats(@RequestParam int busId)  {
        try {
            return ResponseEntity.ok().body(busService.getEmptySeats(busId));
        }catch (InvalidBusId ex){
            ex.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("please provide valid bus id");
    }
}
