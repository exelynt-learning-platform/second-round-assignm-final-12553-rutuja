package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Order;
import com.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService service;

    @PostMapping("/place")
    public String place(@RequestParam String username) {
        return service.placeOrder(username);
    }
    
    @GetMapping("/getallOrders")
    public List<Order> getAllOrders() {
        return service.getAllOrders();
    }
    @GetMapping("/getOrderById/{oid}")
    public Order getOrder(@PathVariable Long oid) {
        return service.getOrderById(oid);
    }

    @DeleteMapping("/deleteOrderById/{oid}")
    public String deleteOrder(@PathVariable Long oid) {
        return service.deleteOrder(oid);
    }
}