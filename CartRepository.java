package com.repository;




import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.Cart;
import com.entity.User;



@Repository
public interface CartRepository extends JpaRepository<Cart,Long> {
	 Cart findByUser(User user);

}
