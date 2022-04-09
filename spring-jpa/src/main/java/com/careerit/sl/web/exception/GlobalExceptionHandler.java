package com.careerit.sl.web.exception;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{

		@ExceptionHandler({IllegalArgumentException.class})
		public ResponseEntity<Object> handleArgumentNotValid(Exception ex, WebRequest request) {
			List<String> list = List.of(ex.getMessage());
			ApiError apiError = new ApiError(LocalDateTime.now(), list,HttpStatus.BAD_REQUEST);
			return new ResponseEntity<>(apiError,HttpStatus.BAD_REQUEST);
		}
		
		
}
