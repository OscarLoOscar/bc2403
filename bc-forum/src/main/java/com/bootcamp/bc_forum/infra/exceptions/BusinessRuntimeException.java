package com.bootcamp.bc_forum.infra.exceptions;

import lombok.Getter;

@Getter
public class BusinessRuntimeException extends RuntimeException{
  
  private int code;

  public BusinessRuntimeException(SysCode sysCode) {
    super(sysCode.getDesc());
    this.code = sysCode.getCode();
  }

}
