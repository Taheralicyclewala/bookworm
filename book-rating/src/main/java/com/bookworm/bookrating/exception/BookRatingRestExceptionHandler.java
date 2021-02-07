package com.bookworm.bookrating.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.bookworm.bookrating.error.ApiError;
import com.bookworm.bookrating.exception.EntityNotFoundException;

@ControllerAdvice
public class BookRatingRestExceptionHandler extends ResponseEntityExceptionHandler {

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
	
	@ExceptionHandler(InvalidIdException.class)
	protected ResponseEntity<Object> handleInvalidIdException(InvalidIdException ex)
	{
		ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST);
		apiError.setMessage(ex.getMessage());
		return buildResponseEntity(apiError);
	}
	
	private ResponseEntity<Object> buildResponseEntity(ApiError apiError) {
        return new ResponseEntity<>(apiError, apiError.getStatus());
    }
}
