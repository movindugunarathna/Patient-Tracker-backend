package com.spring.demo.exception;

public class ClerkNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	private String errorCode;
	private String errorMessage;

	public ClerkNotFoundException(String errorCode, String message) {
		super();
		this.errorCode = errorCode;
		this.errorMessage = message;
	}

	public ClerkNotFoundException() {}
	
	public String getErrorCode(){
        return errorCode;
    }
    public void setErrorCode(String errorCode){
        this.errorCode = errorCode;
    }
	public String getErrorMessage(){
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage){
		this.errorMessage = errorMessage;
	}
	public static long getSerialVersionuid(){
        return serialVersionUID;
    }
}
