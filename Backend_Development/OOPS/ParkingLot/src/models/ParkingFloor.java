package models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ParkingFloor extends BaseModel {
    private int noOfSpots;
    private List<ParkingSpot> parkingSpots;
    private ParkingSpotStatus status;
}
