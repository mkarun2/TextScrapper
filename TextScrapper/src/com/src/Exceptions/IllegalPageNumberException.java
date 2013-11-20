package com.src.Exceptions;

public class IllegalPageNumberException extends Exception{

	private static final long serialVersionUID = 1L;

	public IllegalPageNumberException(String strException) {
		super(strException);
	}
}
