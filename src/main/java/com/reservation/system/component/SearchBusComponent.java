package com.reservation.system.component;

import com.reservation.system.dto.BusDto;
import com.reservation.system.entity.Bus;
import lombok.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Component
public class SearchBusComponent  {

    private List<Bus> busList;
    Map<Integer,Integer> mp;





    public boolean  bookSeat(int busId,int seatCount){
       return true;

    }


}
