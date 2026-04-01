package com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	 @Bean
	    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

	        http
	            .csrf(csrf -> csrf.disable())
	            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/user/register","/user/login",
          "/product/addproducts","/product/getAllProducts","/product/getProductById/{pid}", "/product/deleteProductById/{pid}",
    
	            "/order/place","/cart/addToCart","/order/getallOrders","/order/getOrderById/{oid}","/order/deleteOrderById/{oid}",
  "/payment/success","/payment/cancel")
	                .permitAll()
	                .anyRequest().permitAll()   
	            );

      return http.build();
	
	    }
}