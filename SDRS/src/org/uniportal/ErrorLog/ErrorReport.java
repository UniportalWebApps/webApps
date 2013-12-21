package org.uniportal.ErrorLog;

public class ErrorReport {

	private String name;
	private int ErrorCode;
	private String ErrorMessage;
	private String generatingMethod;
	private String generatingClass;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getErrorCode() {
		return ErrorCode;
	}

	public void setErrorCode(int errorCode) {
		ErrorCode = errorCode;
	}

	public String getErrorMessage() {
		return ErrorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		ErrorMessage = errorMessage;
	}

	public String getGeneratingMethod() {
		return generatingMethod;
	}

	public void setGeneratingMethod(String generatingMethod) {
		this.generatingMethod = generatingMethod;
	}

	public String getGeneratingClass() {
		return generatingClass;
	}

	public void setGeneratingClass(String generatingClass) {
		this.generatingClass = generatingClass;
	}

}
