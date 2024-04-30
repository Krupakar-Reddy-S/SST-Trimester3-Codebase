package dtos;

import lombok.Getter;
import lombok.Setter;
import models.VehicleType;

@Getter
@Setter
public class IssueTicketRequestDto {
    private Long gateId;
    private VehicleType vehicleType;
    private String vehicleNumber;
    private String vehicleOwnerName;
}
