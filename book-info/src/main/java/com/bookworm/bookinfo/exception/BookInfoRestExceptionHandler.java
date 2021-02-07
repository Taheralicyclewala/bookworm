package com.bookworm.bookinfo.exception;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;

import com.bookworm.bookinfo.error.ApiError;

@ControllerAdvice
public class BookInfoRestExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(EntityNotFoundException.class)
	protected ResponseEntity<Object> handleEntityNotFoundExcpetion(EntityNotFoundException ex)
	{

	    ApiError apiError = new ApiError(HttpStatus.NOT_FOUND);
	    apiError.setMessage(ex.getMessage());
	    return buildResponseEntity(apiError);
	}

	protected ResponseEntity<Object> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex)
	{
	    ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST);
            apiError.setMessage("Validation error");
            apiError.addValidationErrors(ex.getBindingResult().getFieldErrors());
            apiError.addValidationError(ex.getBindingResult().getGlobalErrors());
            return buildResponseEntity(apiError);
	}
	
	@Override
	protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex, HttpHeaders headers, HttpStatus status, WebRequest request) 
	{
	    ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST);
	    apiError.setMessage(String.format("Could not find the %s method for URL %s", ex.getHttpMethod(), ex.getRequestURL()));
	    apiError.setDebugMessage(ex.getMessage());
	    return buildResponseEntity(apiError);
	}
	
	
	private ResponseEntity<Object> buildResponseEntity(ApiError apiError) {
        return new ResponseEntity<>(apiError, apiError.getStatus());
    }

}
