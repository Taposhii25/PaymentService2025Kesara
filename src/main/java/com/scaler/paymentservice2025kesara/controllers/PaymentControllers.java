package com.scaler.paymentservice2025kesara.controllers;

import com.scaler.paymentservice2025kesara.services.PaymentServices;
import com.stripe.exception.StripeException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
public class PaymentControllers {
    private PaymentServices paymentServices;
    public PaymentControllers(PaymentServices paymentServices) {
        this.paymentServices = paymentServices;
    }

    //as finally it will return payment link so return type is String
    @PostMapping("/initiate/{orderid}")
    public String initiatepayment(@PathVariable("orderid") Long orderid) throws StripeException {
        return paymentServices.initiatepayment(orderid);
    }
}
