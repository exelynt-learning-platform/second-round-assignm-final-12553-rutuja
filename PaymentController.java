package com.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @GetMapping("/success")
    public String success() {
        return "Payment Successful";
    }

    @GetMapping("/cancel")
    public String cancel() {
        return "Payment Cancelled";
    }
}
