package com.bookworm.bookwormapigateway.exception;

import java.util.Arrays;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.bookworm.bookwormapigateway.dto.ServiceResponse;
import com.bookworm.bookwormapigateway.error.ApiError;


@ControllerAdvice
public class GatewayRestExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(InvalidIdException.class)
	protected ResponseEntity<ServiceResponse> handleInvalidIdException(InvalidIdException ex)
	{
		ServiceResponse serviceResponse = new ServiceResponse();
		serviceResponse.setException(ex.getMessage());
		return buildResponseEntity(serviceResponse);
	}
	
	protected ResponseEntity<ServiceResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex)
	{
	    ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST);
        apiError.addValidationErrors(ex.getBindingResult().getFieldErrors());
        apiError.addValidationError(ex.getBindingResult().getGlobalErrors());
		ServiceResponse serviceResponse = new ServiceResponse();
		serviceResponse.setError(Arrays.deepToString(apiError.getSubErrors().toArray()));
        return buildResponseEntity(serviceResponse);
	}
	
	private ResponseEntity<ServiceResponse> buildResponseEntity(ServiceResponse serviceResponse) {
        return new ResponseEntity<>(serviceResponse,HttpStatus.BAD_REQUEST);
    }

}
