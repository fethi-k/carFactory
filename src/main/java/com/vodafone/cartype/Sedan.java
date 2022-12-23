package com.vodafone.cartype;

import com.vodafone.interfaces.Car;

public class Sedan implements Car {
    @Override
    public String getType() {
        return "Sedan Car has produced.";
    }
}
