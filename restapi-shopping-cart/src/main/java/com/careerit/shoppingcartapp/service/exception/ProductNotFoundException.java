package com.careerit.shoppingcartapp.service.exception;

public class ProductNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -5055391935748944951L;

	public ProductNotFoundException(String message) {
		super(message);
	}

}
