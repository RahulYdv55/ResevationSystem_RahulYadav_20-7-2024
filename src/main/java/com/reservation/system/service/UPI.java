package com.reservation.system.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UPI implements Payment{
    @Override
    public boolean pay() {
        log.info("Payment Success");
        return true;
    }
}
