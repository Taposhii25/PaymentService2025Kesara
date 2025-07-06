package com.scaler.paymentservice2025kesara.paymentgateways;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentLink;
import com.stripe.model.Price;
import com.stripe.model.Product;
import com.stripe.param.PaymentLinkCreateParams;
import com.stripe.param.PriceCreateParams;

import com.stripe.param.ProductCreateParams;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class StripePaymentGateways implements PaymentGateways {
    @Value("${stripe.key}")
    private String apiKey;

    @Override
    public String initiatepayment(Long orderid) throws StripeException {
        Stripe.apiKey = apiKey;

        ProductCreateParams productCreateParams =
                ProductCreateParams.builder().setName("Water Bottle").build();
        Product product = Product.create(productCreateParams);

        PriceCreateParams priceCreateParams =
                PriceCreateParams.builder()
                        .setCurrency("usd")
                        .setUnitAmount(1000L)
                        .setProduct(product.getId().toString())
                        .build();

        Price price = Price.create(priceCreateParams);

        PaymentLinkCreateParams paymentLinkCreateParams =
                PaymentLinkCreateParams.builder()
                        .addLineItem(
                                PaymentLinkCreateParams.LineItem.builder()
                                        .setPrice(price.getId().toString())
                                        .setQuantity(1L)
                                        .build()
                        )
                        .build();

        PaymentLink paymentLink = PaymentLink.create(paymentLinkCreateParams);
        return paymentLink.getUrl();
    }
}
