package com.careerit.shopc.dto;

import java.util.Map;

import com.careerit.shopc.domain.Item;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Order {
	private Map<Item,Integer> itemsMap; 

}
