package com.vodafone.factory;

import com.vodafone.cartype.Cabrio;
import com.vodafone.cartype.Hatchback;
import com.vodafone.cartype.Sedan;
import com.vodafone.interfaces.Car;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class CarFactory {
    public Car createCar(String carType) {

        if (carType == null || carType.isEmpty())
            throw new IllegalArgumentException("Empty or null input.");

        else if (carType.toLowerCase(Locale.ROOT).compareTo(Cabrio.class.getSimpleName().toLowerCase(Locale.ROOT)) == 0) {
            return new Cabrio();
        }
        else if (carType.toLowerCase(Locale.ROOT).compareTo(Sedan.class.getSimpleName().toLowerCase(Locale.ROOT)) == 0) {
            return new Sedan();
        }
        else if (carType.toLowerCase(Locale.ROOT).compareTo(Hatchback.class.getSimpleName().toLowerCase(Locale.ROOT)) == 0) {
            return new Hatchback();
        }
        else {
            throw new IllegalArgumentException("Invalid input.");
        }
    }
}
