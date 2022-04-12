package com.careerit.sl.web.exception;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ApiError {

		private LocalDateTime dateTime;
		private List<String> messages;
		private HttpStatus httpStatus;
}
