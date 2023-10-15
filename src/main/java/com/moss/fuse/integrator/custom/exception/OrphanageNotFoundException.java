package com.moss.fuse.integrator.custom.exception;

public class OrphanageNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	private final String fieldName;

	public OrphanageNotFoundException(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getFieldName() {
		return fieldName;
	}
}
