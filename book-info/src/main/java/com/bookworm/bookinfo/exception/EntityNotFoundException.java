package com.bookworm.bookinfo.exception;


public class EntityNotFoundException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EntityNotFoundException(Class<?> entity,String propertyName,String propertyValue)
	{	
		super(generateMessage(entity.getSimpleName(),propertyName,propertyValue));
	}
	
	private static String generateMessage(String entity, String propertyName,String propertyValue) 
	{
        return String.format("%s was not found for parameters [%s : %s]",entity,propertyName,propertyValue);
    }		


}
