package models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class Bill extends BaseModel {
    private Date exitTime;
    private Ticket ticket;
    private double amount;
    private List<Payment> payments;
}
