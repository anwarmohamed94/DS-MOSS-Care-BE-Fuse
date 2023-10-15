package com.moss.fuse.integrator.custom.exception;

public class MissingQueryParamException  extends Exception{

	private static final long serialVersionUID = 1L;
	
	private final String paramName;

	public MissingQueryParamException(String paramName) {
		this.paramName = paramName;
	}

	public String getParamName() {
		return paramName;
	}
}
