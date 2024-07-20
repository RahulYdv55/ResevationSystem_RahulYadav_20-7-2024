package com.reservation.system.config;

import com.reservation.system.component.SearchBusComponent;
import com.reservation.system.component.UserManagement;
import com.reservation.system.entity.Bus;
import com.reservation.system.entity.Passenger;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Configuration
@Slf4j
public class InItConfig {



    @Bean("withData")
    public SearchBusComponent getBean(){
        log.info("Creating bean");
        Bus bus1 = Bus.builder()
                .busId(101)
                .totalSeat(20)
                .routes("Ahmadabad,Amreli,Bharuch,Bhavnagar,Bhuj,Dwarka").build();

        Bus bus2 = Bus.builder()
                .busId(102)
                .totalSeat(20)
                .routes("Gandhinagar,Godhra,Jamnagar,Junagadh,Kandla,Khambhat").build();

        Bus bus3 = Bus.builder()
                .busId(103)
                .totalSeat(20)
                .routes("Kheda,Mahesana,Morbi,Nadiad,Navsari,Okha").build();

        Bus bus4 = Bus.builder()
                .busId(104)
                .totalSeat(20)
                .routes("Palanpur,Patan,Porbandar,Rajkot,Surat,Surendranagar").build();

        Bus bus5 = Bus.builder()
                .busId(105)
                .totalSeat(20)
                .routes("Ambala,Bhiwani,Chandigarh,Faridabad,Gurugram,Hansi").build();
        Bus bus6 = Bus.builder()
                .busId(106)
                .totalSeat(20)
                .routes("China,Amreli,India,USA,Bhuj,Dubal").build();
        List<Bus> busList = new ArrayList<>();
        busList.add(bus1);
        busList.add(bus2);
        busList.add(bus3);
        busList.add(bus4);
        busList.add(bus5);
        busList.add(bus6);
        Map<Integer,Integer> mp = new HashMap<>();
        for(Bus bus : busList){
            mp.put(bus.getBusId(), 0);
        }
        SearchBusComponent searchBusComponent = new SearchBusComponent(busList,mp);
        log.info("bean {}",searchBusComponent);
        return searchBusComponent;
    }

    @Bean
    public UserManagement getPassengetList(){
        Passenger p1 = Passenger.builder()
                .userId(100)
                .name("Rohit")
                .email("rohit@gmail.com")
                .phone("987654321")
                .build();

        Passenger p2 = Passenger.builder()
                .userId(101)
                .name("Raj")
                .email("raj@gmail.com")
                .phone("987654321")
                .build();

        Passenger p3 = Passenger.builder()
                .userId(102)
                .name("Anuj")
                .email("anuj@gmail.com")
                .phone("987654321")
                .build();

        Passenger p4 = Passenger.builder()
                .userId(103)
                .name("Ankit")
                .email("ankit@gmail.com")
                .phone("987654321")
                .build();
        List<Passenger> passengerList = new ArrayList<>();
        passengerList.add(p1);
        passengerList.add(p2);
        passengerList.add(p3);
        passengerList.add(p4);

        return new UserManagement(passengerList);
    }


}
