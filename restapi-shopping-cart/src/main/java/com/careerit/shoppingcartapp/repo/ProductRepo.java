package com.careerit.shoppingcartapp.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.careerit.shoppingcartapp.domain.Product;


public interface ProductRepo extends JpaRepository<Product, Long> {

	@Query("SELECT m FROM Product m WHERE m.name LIKE %:str%")
	List<Product> searchByTitleLike(@Param("str") String str);
	

}
