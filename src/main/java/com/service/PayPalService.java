package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paypal.api.payments.Amount;
import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payer;
import com.paypal.api.payments.Payment;
import com.paypal.api.payments.RedirectUrls;
import com.paypal.api.payments.Transaction;
import com.paypal.base.rest.APIContext;



@Service
public class PayPalService {

    @Autowired
    private APIContext apiContext;

    public String createPayment(Double amount) {

        try {
          
            Amount amt = new Amount();
            amt.setCurrency("INR");
            amt.setTotal(String.format("%.2f", amount));

            Transaction transaction = new Transaction();
            transaction.setAmount(amt);

            Payer payer = new Payer();
            payer.setPaymentMethod("paypal");

            Payment payment = new Payment();
            payment.setIntent("sale");
            payment.setPayer(payer);
            payment.setTransactions(List.of(transaction));

            
            RedirectUrls urls = new RedirectUrls();
            urls.setCancelUrl("http://localhost:8080/payment/cancel");
         urls.setReturnUrl("http://localhost:8080/payment/success");

            payment.setRedirectUrls(urls);

       
            Payment created = payment.create(apiContext);

                        for (Links link : created.getLinks()) {
                if (link.getRel().equals("approval_url")) {
                    return link.getHref();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            return "Error creating payment";
        }

        return null;
    }
}