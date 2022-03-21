package com.careerit.task1.dto;

import com.careerit.task1.domain.Qualification;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StudentDTO {
	private String name;
    private Qualification qualification;
    private double score;

}
