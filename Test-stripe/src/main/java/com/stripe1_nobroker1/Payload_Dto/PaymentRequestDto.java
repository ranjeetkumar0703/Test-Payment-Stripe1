package com.stripe1_nobroker1.Payload_Dto;

import lombok.Data;


@Data

public class PaymentRequestDto {
    private long amount;
    private String currency;
    private  String tokenId;

}
