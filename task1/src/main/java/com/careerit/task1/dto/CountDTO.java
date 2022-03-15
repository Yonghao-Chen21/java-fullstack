package com.careerit.task1.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CountDTO {
	private int placedCount;
    private int notPlacedCount;
}
