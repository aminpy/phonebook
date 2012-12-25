package com.aminpy.phonebook.exception;

public class NumberDuplicateException extends Exception {
	private static final long serialVersionUID = -6113826235231658999L;

	public NumberDuplicateException() {
		super();
	}

	public NumberDuplicateException(String message) {
		super(message);
	}
}
