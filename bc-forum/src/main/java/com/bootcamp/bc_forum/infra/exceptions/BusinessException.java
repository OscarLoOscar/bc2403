package com.bootcamp.bc_forum.infra.exceptions;

import lombok.Getter;

@Getter
public class BusinessException extends Exception{
  
  private int code;

  public BusinessException(SysCode syscode){
    super(syscode.getDesc());
    this.code = syscode.getCode();
  }
}
