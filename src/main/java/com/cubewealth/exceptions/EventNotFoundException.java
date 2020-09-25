package com.cubewealth.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EventNotFoundException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public EventNotFoundException() {
		super("Event does not exist!");
	}
}
