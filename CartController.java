package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Cart;
import com.service.CartService;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService service;

    @PostMapping("/addToCart")
    public Cart add(@RequestParam String username,
                    @RequestParam Long productId,
                    @RequestParam int qty) {

        return service.addToCart(username, productId, qty);
    }
}
