package org.boynesoftware.configuration.exception;

public enum ErrorCode {

	INTERAL_ERROR("ERR_001"), NO_USER_APP_PROF("ERR_002"),USER_ALREADY_EXISTS("ERR_003"),APP_IS_NULL("ERR_004"),ORG_IS_NULL("ERR_005"),
	USER_IS_NULL("ERR_006");
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	private String code;

	private ErrorCode(String code) {
		this.code = code;
	}

}
