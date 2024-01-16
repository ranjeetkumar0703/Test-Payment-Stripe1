package com.stripe1_nobroker1.controller;

import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import com.stripe.param.PaymentIntentCreateParams;
import com.stripe1_nobroker1.Payload_Dto.PaymentRequestDto;
import com.stripe1_nobroker1.Payload_Dto.StripeTokenDto;
import com.stripe1_nobroker1.service.StripeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
@AllArgsConstructor
public class StripeApiController {
    private final StripeService stripeService;


    //http://localhost:9095/payments/card/token
    @PostMapping("/card/token")
    public String createCardToken(@RequestBody StripeTokenDto model){
        return stripeService.createToken(model.getCardNumber(),model.getExpMonth(),model.getExpYear(),model.getCvc());


    }

    @PostMapping("/charge")
    public String charge(@RequestBody PaymentRequestDto paymentRequestDto) throws StripeException {

        PaymentIntentCreateParams params=
                PaymentIntentCreateParams.builder()
                .setAmount(paymentRequestDto.getAmount())
                .setCurrency(paymentRequestDto.getCurrency())
                .setPaymentMethod(paymentRequestDto.getTokenId())
                .build();

        PaymentIntent paymentIntent=PaymentIntent.create(params);
        System.out.println(paymentIntent);
        return "done";
    }

}
