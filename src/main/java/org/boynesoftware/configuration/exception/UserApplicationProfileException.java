package org.boynesoftware.configuration.exception;

public class UserApplicationProfileException extends RuntimeException {

	private static final long serialVersionUID = 1385664054539069427L;

	private ErrorCode code;

	public UserApplicationProfileException() {
		super();
	}

	public UserApplicationProfileException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public UserApplicationProfileException(String message, Throwable cause) {
		super(message, cause);
	}

	public UserApplicationProfileException(String message, ErrorCode code) {
		super(message);
		this.code = code;
	}

	public UserApplicationProfileException(Throwable cause) {
		super(cause);
	}

	public ErrorCode getCode() {
		return code;
	}

}
