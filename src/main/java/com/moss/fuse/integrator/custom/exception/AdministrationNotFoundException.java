package com.moss.fuse.integrator.custom.exception;

public class AdministrationNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	private final String fieldName;

	public AdministrationNotFoundException(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getFieldName() {
		return fieldName;
	}
}
