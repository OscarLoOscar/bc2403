package com.bootcamp.bc_forum.infra.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.RestClientException;
import com.fasterxml.jackson.core.JsonProcessingException;

@RestControllerAdvice
public class SelfGlobalExceptionHandler extends GlobalExceptionHandler {

  // try to catch NotFoundException
  // if it is caught, call this java method, it passes the input parameter as well.

  // @ExceptionHandler(NotFoundException.class) // catch
  // public ErrorResponse notFoundExceptionHandler(NotFoundException e) {
  // return new ErrorResponse(e.getCode(), e.getMessage());
  // }

  // @ExceptionHandler(UserNotFoundException.class) // catch
  // public ErrorResponse userNotFoundExceptionHandler(UserNotFoundException e) {
  // return new ErrorResponse(e.getCode(), e.getMessage());
  // }

  @ExceptionHandler(BusinessRuntimeException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ErrorResponse businessRuntimeExceptionHandler(
      BusinessRuntimeException e) {
    return  ErrorResponse.of(e.getCode(), e.getMessage());
  }

  @ExceptionHandler(RestClientException.class)
  public ErrorResponse restClientExceptionHandler(RestClientException e) {
    return ErrorResponse.of(SysCode.REST_TEMPLATE_ERROR.getCode(),
        SysCode.REST_TEMPLATE_ERROR.getDesc());
  }
  
  @ExceptionHandler(JsonProcessingException.class)
  public ErrorResponse jsonProcessingException(JsonProcessingException e) {
    return ErrorResponse.of(SysCode.REST_TEMPLATE_ERROR.getCode(),
        SysCode.REST_TEMPLATE_ERROR.getDesc());
  }
}
