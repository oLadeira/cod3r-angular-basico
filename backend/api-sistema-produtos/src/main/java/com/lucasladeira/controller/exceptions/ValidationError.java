package com.lucasladeira.controller.exceptions;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;


public class ValidationError extends StandardErrorBody{

	private static final long serialVersionUID = 1L;

	private List<FieldMessage> errors = new ArrayList<>();
	
	public ValidationError() {}
	
	public ValidationError(Instant timestamp, Integer status, String error, String message, String path) {
		super(timestamp, status, error, message, path);
		// TODO Auto-generated constructor stub
	}


	public List<FieldMessage> getErrors() {
		return errors;
	}


	public void addError(String fieldName, String message) {
		errors.add(new FieldMessage(fieldName, message));
	}
	
}
