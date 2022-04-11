package com.careerit.shoppingcartapp.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Product {

		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private Long pid;
		private String name;
		private String description;
		private double price;
		private boolean status;
		
		
}
