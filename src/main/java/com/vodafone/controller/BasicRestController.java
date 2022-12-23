package com.vodafone.controller;

import com.vodafone.factory.CarFactory;
import com.vodafone.interfaces.Car;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasicRestController {
    private final CarFactory carFactory;

    public BasicRestController(CarFactory carFactory) {
        this.carFactory = carFactory;
    }

    @GetMapping("/")
    public String getInfo() {
        return "Please try type /producecar at the end of the address and send GET request. Add a parameter key called 'type' to this request.";
    }

    @GetMapping("/producecar")
    public String produceCar(String type) {
        try {
            Car createdCar = carFactory.createCar(type);
            return createdCar.getType();
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }
    }
}
