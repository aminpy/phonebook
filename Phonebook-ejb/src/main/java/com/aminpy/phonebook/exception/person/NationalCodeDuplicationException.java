package com.aminpy.phonebook.exception.person;

public class NationalCodeDuplicationException extends Exception {
	private static final long serialVersionUID = -6113826235231658999L;

	public NationalCodeDuplicationException() {
		super();
	}

	public NationalCodeDuplicationException(String message) {
		super(message);
	}
}
