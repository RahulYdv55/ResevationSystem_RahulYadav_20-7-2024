package com.reservation.system.service;

public class CreditCard implements Payment{
    @Override
    public boolean pay() {
        return false;
    }
}
