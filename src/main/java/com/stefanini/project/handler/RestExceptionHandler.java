package com.stefanini.project.handler;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.stefanini.project.exception.BusinessException;
import com.stefanini.project.exception.MultiBusinessException;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
	
	  @ExceptionHandler(BusinessException.class)
	    protected ResponseEntity<?> handleException(BusinessException ex) {

	        ExceptionResponse responseMessage =
	                ExceptionResponse.Builder
	                        .newBuilder()
	                        .timestamp(new Date().getTime())
	                        .status(HttpStatus.UNPROCESSABLE_ENTITY.value())
	                        .title("Business Exception")
	                        .addDetail(ex.getMessage())
	                        .developerMessage(ex.getClass().getName())
	                        .build();

	        return new ResponseEntity<>(responseMessage,
	                HttpStatus.UNPROCESSABLE_ENTITY);
	    }

	    @ExceptionHandler(MultiBusinessException.class)
	    protected ResponseEntity<?> handleException(MultiBusinessException ex) {

	        ExceptionResponse responseMessage =
	                ExceptionResponse.Builder
	                        .newBuilder()
	                        .timestamp(new Date().getTime())
	                        .status(HttpStatus.UNPROCESSABLE_ENTITY.value())
	                        .title("Business Exception")
	                        .detail(ex.getExceptionsList())
	                        .developerMessage(ex.getClass().getName())
	                        .build();

	        return new ResponseEntity<>(responseMessage,
	                HttpStatus.UNPROCESSABLE_ENTITY);
	    }


	    @ExceptionHandler(RuntimeException.class)
	    protected ResponseEntity<?> handleException(RuntimeException ex) {
	        ExceptionResponse responseMessage =
	                ExceptionResponse.Builder
	                        .newBuilder()
	                        .timestamp(new Date().getTime())
	                        .status(HttpStatus.UNPROCESSABLE_ENTITY.value())
	                        .title("Runtime Exception")
	                        .addDetail(ex.getMessage())
	                        .developerMessage(ex.getClass().getName())
	                        .build();
	        return new ResponseEntity<>(responseMessage,
	                HttpStatus.UNPROCESSABLE_ENTITY);
	    }
  
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		List<ErrorDetail> mensagensDeCadaValidação = getMessagensDeErro(ex);
		
		ExceptionValidationResponse responseMessage = 
				ExceptionValidationResponse.Builder
					.newBuilder()
					.timestamp(new Date().getTime())
					.status(status.value())
					.title("Bussiness Exception")
					.detail(mensagensDeCadaValidação)
					.developerMessage(ex.getClass().getName()).build();
		
		return new ResponseEntity<>(responseMessage, status);
	}
	
	private List<ErrorDetail> getMessagensDeErro(MethodArgumentNotValidException ex) {
        return ex.getBindingResult().getFieldErrors().stream()
                .map(error -> new ErrorDetail(error.getDefaultMessage(), error.getField(), error.getRejectedValue()))
                .collect(Collectors.toList());
    }
}
