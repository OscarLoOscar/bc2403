package com.bootcamp.bc_forum.infra.exceptions;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.RestClientException;
import lombok.Getter;

// @RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(NumberFormatException.class) // catch
  public ErrorResponse numberFormatExceptionHandler(NumberFormatException e) {
    return ErrorResponse.of(ErrorCode.NFE.getCode(), ErrorCode.NFE.getDesc());
  }

  // @ExceptionHandler(NullPointerException.class) // catch
  // public ErrorResponse nullPointerExceptionHandler(NullPointerException e) {
  //   return ErrorResponse.of(ErrorCode.NPE.getCode(), ErrorCode.NPE.getDesc());
  // }

  @ExceptionHandler(ArithmeticException.class) // catch
  public ErrorResponse arithmeticExceptionHandler(ArithmeticException e) {
    return ErrorResponse.of(ErrorCode.AE.getCode(), ErrorCode.AE.getDesc());
  }


  @Getter
  private enum ErrorCode {
    NPE(99, "Null Pointer Exception."), //
    NFE(99, "Number Format Exception."), //
    AE(99, "Arithmetic Exception."), //
    ;

    private int code;
    private String desc;

    private ErrorCode(int code, String desc) {
      this.code = code;
      this.desc = desc;
    }
  }
}
