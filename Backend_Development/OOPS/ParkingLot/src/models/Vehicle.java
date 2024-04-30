package models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Vehicle {
    private User owner;
    private VehicleType vehicleType;
}
