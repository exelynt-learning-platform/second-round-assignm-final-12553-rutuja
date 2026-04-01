package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Cart;
import com.entity.CartItem;
import com.entity.Order;
import com.entity.Product;
import com.entity.User;
import com.repository.CartRepository;
import com.repository.OrderRepository;
import com.repository.UserRepository;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepo;

    @Autowired
    private CartRepository cartRepo;

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private PayPalService payPalService;

    public String placeOrder(String username) {

        User user = userRepo.findByUsername(username);
        Cart cart = cartRepo.findByUser(user);

        Order order = new Order();
        order.setUser(user);

        List<Product> products = cart.getItems()
                .stream()
                .map(CartItem::getProduct)
                .toList();

        order.setProducts(products);

        double total = cart.getItems().stream()
                .mapToDouble(i -> i.getProduct().getPrice() * i.getQuantity())
                .sum();

        order.setTotalPrice(total);
        order.setPaymentStatus("PENDING");

        orderRepo.save(order);

        return payPalService.createPayment(total);
    }
    public Order getOrderById(Long oid) {
        return orderRepo.findById(oid).orElse(null);
    }
    public List<Order> getAllOrders() {
        return orderRepo.findAll();
    }
    public String deleteOrder(Long oid) {
        orderRepo.deleteById(oid);
        return "Order deleted successfully";
    }
}