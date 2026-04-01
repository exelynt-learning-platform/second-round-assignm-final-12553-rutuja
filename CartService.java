package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Cart;
import com.entity.CartItem;
import com.entity.Product;
import com.entity.User;
import com.repository.CartRepository;
import com.repository.ProductRepository;
import com.repository.UserRepository;

@Service
public class CartService {
	@Autowired
	CartRepository cartRepo;
	   @Autowired
	    private ProductRepository productRepo;

	    @Autowired
	    private UserRepository userRepo;
	    public Cart addToCart(String username, Long productId, int qty) {

	        User user = userRepo.findByUsername(username);
	        Cart cart = cartRepo.findByUser(user);

	        if (cart == null) {
	            cart = new Cart();
	            cart.setUser(user);
	        }

	        Product product = productRepo.findById(productId).get();

	        CartItem item = new CartItem();
	        item.setProduct(product);
	        item.setQuantity(qty);
	      
	        cart.getItems().add(item);

	        return cartRepo.save(cart);
	    }
}
