package com.bookworm.bookwormapigateway.dto;

import java.io.Serializable;

/** It represents a standard Response payload class for all the API request. It wraps the response of Service either it is a result, error or
 * exception generated after calling the services.
 * 
 * @author Taher */
public class ServiceResponse implements Serializable {
    private static final long serialVersionUID = 1L;

    /** Represents the status of request either true or false. By default its value is true. */
    private Boolean success = true;

    /** Specifies if there is an exception occured in calling service or not. */
    private Boolean isException = false;

    /** Specifies If the service response contains a result or not. */
    private Boolean hasResult = false;

    /** Represents the Exception message generated in fulfilling API request. */
    private String exception = "";

    /** Specifies the result generated after calling API service. */
    private Object result = null;
    /** Specifies the Occurance of an error after calling the API service. */
    private Boolean isError = false;

    /** Specifies the error message of the error occured after calling the API service. */
    private String error = "";

    /** Creates a Service Response. */
    public ServiceResponse() {
        super();
    }
    
    public ServiceResponse(Object result)
    {
    	this.setResult(result);
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Boolean getIsException() {
        return isException;
    }

    public void setIsException(Boolean isException) {
        this.isException = isException;
    }

    public Boolean getHasResult() {
        return hasResult;
    }

    public void setHasResult(Boolean hasResult) {
        this.hasResult = hasResult;
    }

    public String getException() {
        return exception;
    }

    public Boolean getIsError() {
        return isError;
    }

    public void setIsError(Boolean isError) {
        this.isError = isError;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.setSuccess(false);
        this.isError = true;
        this.error = error;
    }

    public void setException(String exception) {
        this.setSuccess(false);
        this.setIsException(true);
        this.exception = exception;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.setHasResult(true);
        this.result = result;
    }
}