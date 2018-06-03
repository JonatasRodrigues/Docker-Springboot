package br.com.rj.desafio.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class RecursoNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public RecursoNotFoundException(String msg) {
		super(msg);
	}
}
