package com.example.errorobjects;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Error {
	private String errorMessage;
	private String errorCode;

	public Error(String errorMessage, String errorCode) {
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public Error setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
		return this;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public Error setErrorCode(String errorCode) {
		this.errorCode = errorCode;
		return this;
	}

	@Override
	public String toString() {
		return "Error [errorMessage=" + errorMessage + ", errorCode=" + errorCode + "]";
	}

}
