package com.scaler.paymentservice2025kesara.paymentgateways;

import org.springframework.stereotype.Component;

@Component
public class RazorPamentGateway implements PaymentGateways {

    @Override
    public String initiatepayment(Long orderid) {
        return "";
    }
}
