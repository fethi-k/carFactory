package com.vodafone.cartype;

import com.vodafone.interfaces.Car;

public class Hatchback implements Car {
    @Override
    public String getType() {
        return "Hatchback Car has produced.";
    }
}
