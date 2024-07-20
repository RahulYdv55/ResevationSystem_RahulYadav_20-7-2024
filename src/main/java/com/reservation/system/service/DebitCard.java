package com.reservation.system.service;

public class DebitCard implements Payment{
    @Override
    public boolean pay() {
        return false;
    }
}
