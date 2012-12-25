package com.aminpy.phonebook.exception.contactnumber;

public class NumberDuplicationException extends Exception {
	private static final long serialVersionUID = -6113826235231658999L;

	public NumberDuplicationException() {
		super();
	}

	public NumberDuplicationException(String message) {
		super(message);
	}
}
