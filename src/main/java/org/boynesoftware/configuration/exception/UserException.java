package org.boynesoftware.configuration.exception;

public class UserException extends RuntimeException
{

	public UserException()
	{
		super();
	}

	public UserException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace)
	{
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public UserException(String message, Throwable cause)
	{
		super(message, cause);
	}

	public UserException(String message, ErrorCode code)
	{
		super(message);
	}

	public UserException(Throwable cause)
	{
		super(cause);
	}

}
