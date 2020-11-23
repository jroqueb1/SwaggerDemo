package com.appsdeveloperblog.app.ws.exceptions;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.appsdeveloperblog.app.ws.models.response.ErrorMessage;

@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {

//	@ResponseStatus(HttpStatus.BAD_REQUEST)
//	@ExceptionHandler(MethodArgumentNotValidException.class)
//	public Map<String, String> handleValidationExceptions(
//	  MethodArgumentNotValidException ex) {
//	    Map<String, String> errors = new HashMap<>();
//	    ex.getBindingResult().getAllErrors().forEach((error) -> {
//	        String fieldName = ((FieldError) error).getField();
//	        String errorMessage = error.getDefaultMessage();
//	        errors.put(fieldName, errorMessage);
//	    });
//	    return errors;
//	}
	
	@ExceptionHandler(value = { Exception.class })
	public ResponseEntity<Object> handleAnyException(Exception ex, WebRequest request) {
		
		ErrorMessage errorMsg = new ErrorMessage();
		String message = ex.getMessage();

		errorMsg.setTimestamp(new Date());
		errorMsg.setRequest(request.toString());
		errorMsg.setMessage(message == null ? ex.toString() : message);
		
		return new ResponseEntity<>(
			errorMsg, new HttpHeaders(), 
				HttpStatus.INTERNAL_SERVER_ERROR
		);

	}
	
	@ExceptionHandler(value = { NullPointerException.class })
	public ResponseEntity<Object> handleNullPointerExceptionn(NullPointerException ex, WebRequest request) {
		
		ErrorMessage errorMsg = new ErrorMessage();
		String message = ex.getMessage();

		errorMsg.setTimestamp(new Date());
		errorMsg.setRequest(request.toString());
		errorMsg.setMessage(message == null ? ex.toString() : message);
		
		return new ResponseEntity<>(
			errorMsg, new HttpHeaders(), 
				HttpStatus.INTERNAL_SERVER_ERROR
		);

	}	
	
}
