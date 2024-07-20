package com.reservation.system.service;


import com.reservation.system.Exception.InvalidBusId;
import com.reservation.system.component.SearchBusComponent;
import com.reservation.system.dto.BusDto;
import com.reservation.system.entity.Bus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class BusService {


    @Autowired
    @Qualifier("withData")
    private SearchBusComponent searchBusComponent;

    public List<BusDto> searchBus(String from,String to){
        List<BusDto> res=new ArrayList<>();
        Map<Integer,Integer> mp = searchBusComponent.getMp();
        for(Bus b:searchBusComponent.getBusList()){
            log.info("Current bus : {}",b);
            String[] routes= b.getRoutes().split(",");
            int fromFlag=0;
            List<String> routesToFollow=new ArrayList<>();
            for(String str:routes){
                if(from.equalsIgnoreCase(str)){
                    fromFlag=1;
                    routesToFollow.add(str);
                    continue;
                }
                if(fromFlag==1 && to.equalsIgnoreCase(str) && b.getBusId()-mp.get(b.getBusId())>0){
                    routesToFollow.add(str);
                    BusDto busDto = BusDto.builder()
                            .busId(b.getBusId())
                            .availableSeats(b.getTotalSeat()-mp.get(b.getBusId()))
                            .routes(routesToFollow).build();
                    res.add(busDto);
                    break;
                }
                if(fromFlag==1){
                    routesToFollow.add(str);
                }
            }
        }
        return res;
    }

    public Integer getEmptySeats(int busId) throws InvalidBusId {
        if(searchBusComponent.getMp().containsKey(busId)){

            for(Bus bus : searchBusComponent.getBusList()){
                if(bus.getBusId()==busId)
                    return bus.getTotalSeat()-searchBusComponent.getMp().get(busId);
            }
        }
        else
            throw new InvalidBusId("Please provide valid bus ID");
        return null;

    }

}
