package com.scaler.paymentservice2025kesara.paymentgateways;

import com.stripe.exception.StripeException;

public interface PaymentGateways {
    String initiatepayment(Long orderid) throws StripeException;
}
