package com.example.alanjames.event.core.events.sympla.api.http;

import com.example.alanjames.event.core.events.sympla.api.EventickAPIException;

public class HttpException extends EventickAPIException {

	private static final long serialVersionUID = 5824358045739144490L;

	public HttpException(String msg, String token) {
		super(msg, token);
	}

	public HttpException(Throwable cause) {
		super(cause);
	}

	public HttpException(String msg, Throwable cause) {
		super(msg, cause);
	}
}