package com.bookworm.bookrating.exception;

public class EntityNotFoundException extends RuntimeException{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static final String messageFormat = "%s was not found for parameters [%s : %s]"; 

	public EntityNotFoundException(Class<?> entity,String propertyName,String propertyValue)
	{	
		super(generateMessage(entity.getSimpleName(),propertyName,propertyValue));
	}
	
	private static String generateMessage(String entity, String propertyName,String propertyValue) 
	{
        return String.format(messageFormat,entity,propertyName,propertyValue);
    }		

}
