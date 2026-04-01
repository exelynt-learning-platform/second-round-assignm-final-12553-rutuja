package com.config;

import org.springframework.context.annotation.Configuration;
import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;

import org.springframework.beans.factory.annotation.Value;

import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.OAuthTokenCredential;
@Configuration
public class PayPalConfig {
	@Value("${paypal.client.id}")
    private String clientId;

    @Value("${paypal.client.secret}")
    private String clientSecret;

    @Value("${paypal.mode}")
    private String mode;

  
    private Map<String, String> paypalConfig() {
        Map<String, String> config = new HashMap<>();
        config.put("mode", mode); 
        return config;
    }


    @Bean
    public APIContext apiContext() {
        APIContext context = new APIContext(clientId, clientSecret, mode);
        context.setConfigurationMap(paypalConfig());
        return context;
    }

  
    @Bean
    public OAuthTokenCredential oAuthTokenCredential() {
        return new OAuthTokenCredential(clientId, clientSecret, paypalConfig());
    }
}

