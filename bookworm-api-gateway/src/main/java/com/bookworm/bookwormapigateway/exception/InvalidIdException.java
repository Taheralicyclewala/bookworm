package com.bookworm.bookwormapigateway.exception;

public class InvalidIdException extends RuntimeException{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static final String messageFormat = "Invalid Id passed: [%s : %s]";

	public InvalidIdException(String IdName, String IdValue)
	{
		super(generateMessage(IdName,IdValue));
	}
	
	private static String generateMessage(String IdName, String IdValue)
	{
		return String.format(messageFormat, IdName,IdValue);
	}
}
