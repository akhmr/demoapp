package com.demoapp.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.demoapp.response.Response;

@EnableWebMvc
@ControllerAdvice
public class RestExceptionResolver {
	
	@ExceptionHandler(value = {RuntimeException.class})
    protected ResponseEntity<Response<?>> handleKnownException(RuntimeException e, WebRequest request) {
        return new ResponseEntity<Response<?>>(new Response<Object>("500", e.getMessage(), null), HttpStatus.OK);
    }

}
