package com.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class CartItem {
	 @Id 
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	    private Long ciId;

	    @ManyToOne
	    private Product product;

	    private int quantity;

		public CartItem() {
			super();
		}

		public CartItem(Long ciId, Product product, int quantity) {
			super();
			this.ciId = ciId;
			this.product = product;
			this.quantity = quantity;
		}

		public Long getCiId() {
			return ciId;
		}

		public void setCiId(Long ciId) {
			this.ciId = ciId;
		}

		public Product getProduct() {
			return product;
		}

		public void setProduct(Product product) {
			this.product = product;
		}

		public int getQuantity() {
			return quantity;
		}

		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}
	    

}
