package com.careerit.task1.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StudentDTO {
	private String name;
    private String qualification;
    private double score;

}
