package com.src.Exceptions;

public class DocumentParseError extends Exception{

	private static final long serialVersionUID = 1L;

	public DocumentParseError(String strException) {
		super(strException);
	}
}
