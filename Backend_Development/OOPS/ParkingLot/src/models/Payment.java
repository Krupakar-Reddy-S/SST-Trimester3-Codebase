package models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Payment extends BaseModel {
    private double amount;
    private Date time;
    private PaymentMode paymentMode;
    private PaymentStatus paymentStatus;
    private String referenceId;
}
