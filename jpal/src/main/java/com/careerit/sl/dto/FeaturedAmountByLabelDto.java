package com.careerit.sl.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FeaturedAmountByLabelDto {
	private String label;
	private double minAmount;
	private double avgAmount;
	private double maxAmount;

}
