package com.stripe1_nobroker1.service;

import com.stripe.Stripe;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class StripeService {

    @Value("${stripe.api.key}")
    private String STRIPE_SECRET_KEY;

    @PostConstruct
    public void init(){

        Stripe.apiKey=STRIPE_SECRET_KEY;
    }


    public String createToken(String cardNumber,String expMonth,String expYear,String cvc){
        return "pm_card_visa";

    }

}
