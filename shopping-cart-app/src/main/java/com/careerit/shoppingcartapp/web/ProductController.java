package com.careerit.shoppingcartapp.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.careerit.shoppingcartapp.domain.Product;
import com.careerit.shoppingcartapp.service.ProductService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/product")
@Slf4j
public class ProductController {

	private ProductService productService;

	@Autowired
	public ProductController(final ProductService productService) {
		this.productService = productService;
	}

	@PostMapping
	public Product addProduct(@RequestBody Product product) {
		return productService.addProduct(product);
	}

	@PutMapping
	public Product updateProduct(@RequestBody Product product) {
		return productService.updateProduct(product);
	}

	@DeleteMapping("/{pid}")
	public String deleteProduct(@PathVariable("pid") Long pid) {
		boolean res = productService.removeProduct(pid);
		return res ? "Product is deleted" : "Product is not found for given id";
	}

	@GetMapping("/search")
	public List<Product> search(HttpServletRequest request) {
		String str = request.getParameter("str");
		log.info("Search String is :{}",str);
		return productService.search(str);
	}

	@GetMapping("/all")
	public List<Product> getProducts() {
		return productService.getProducts();
	}

}
