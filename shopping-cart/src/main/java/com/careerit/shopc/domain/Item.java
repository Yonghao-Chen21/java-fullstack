package com.careerit.shopc.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Item {
	private Long id;
	private String name;
	private double price;
}
