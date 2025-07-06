package com.scaler.paymentservice2025kesara.services;

import com.scaler.paymentservice2025kesara.paymentgateways.PaymentGateways;
import com.stripe.exception.StripeException;
import org.springframework.stereotype.Service;

@Service
public class PaymentServices {
    private PaymentGateways paymentGateways;
    public PaymentServices (PaymentGateways paymentGateways) {
        this.paymentGateways = paymentGateways;
    }
    public String initiatepayment(Long orderid) throws StripeException {
        //order details
        //make a call to payment gateway to get a link
        paymentGateways.initiatepayment(orderid);

        return paymentGateways.initiatepayment(orderid);
    }
}
