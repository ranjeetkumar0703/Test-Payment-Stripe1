package com.stripe1_nobroker1.Payload_Dto;

import lombok.Data;


@Data
public class StripeTokenDto {
    private String cardNumber;
    private String expMonth;
    private String expYear;
    private String cvc;
    private String username;
}
