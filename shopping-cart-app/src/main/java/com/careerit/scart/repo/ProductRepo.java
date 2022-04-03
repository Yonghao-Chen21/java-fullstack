package com.careerit.scart.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.careerit.scart.domain.Product;

public interface ProductRepo extends JpaRepository<Product, Long> {

	@Query("SELECT m FROM Product m WHERE m.name LIKE %:str%")
	List<Product> searchByTitleLike(@Param("str") String str);
	

}
