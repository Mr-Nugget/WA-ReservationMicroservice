package com.wildadventure.booking.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class BookingStatusErrorException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BookingStatusErrorException() {
		// TODO Auto-generated constructor stub
	}

	public BookingStatusErrorException(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public BookingStatusErrorException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public BookingStatusErrorException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	public BookingStatusErrorException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
		// TODO Auto-generated constructor stub
	}

}
