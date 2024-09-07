package com.javaweb.controllerAdvice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.javaweb.Model.ErrorReponseDTO;

import customException.FieldRequiredException;

@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {
	@ExceptionHandler(ArithmeticException.class)
	public ResponseEntity<Object> mathmaticExceptionEntity(ArithmeticException ex, WebRequest request) {

		ErrorReponseDTO errorReponseDTO = new ErrorReponseDTO();
		errorReponseDTO.setError(ex.getMessage());
		List<String> list = new ArrayList<String>();
		list.add("Để ý lỗi toán học không chia được cho 0");
		errorReponseDTO.setDetail(list);
		return new ResponseEntity<>(errorReponseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(FieldRequiredException.class)
	public ResponseEntity<Object> FieldRequiredException(FieldRequiredException ex, WebRequest request) {

		ErrorReponseDTO errorReponseDTO = new ErrorReponseDTO();
		errorReponseDTO.setError(ex.getMessage());
		List<String> list = new ArrayList<String>();
		list.add("Lỗi dữ liệu trả về xâu rỗng hoặc null");
		errorReponseDTO.setDetail(list);
		return new ResponseEntity<>(errorReponseDTO, HttpStatus.BAD_GATEWAY);
	}
}