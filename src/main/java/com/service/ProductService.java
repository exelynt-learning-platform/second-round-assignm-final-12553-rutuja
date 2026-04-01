package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Product;
import com.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepo;
    public Product add(Product product) {
    	
    				
    			if(product.getPname()!=null && product.getPrice()!=0 &&  product.getDescription()!=null &&  product.getStock()!=0 ) {
    			

    				  return productRepo.save(product);
    			}
				return null;
    			
    }

    public List<Product> getAll() {
        return productRepo.findAll();
    }
    
    public Product getProductById(Long pid) {
        return productRepo.findById(pid).orElse(null);
    }

    public String deleteProduct(Long pid) {
        productRepo.deleteById(pid);
        return "Product deleted successfully" ;
    }

}
