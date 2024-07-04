package com.bootcamp.bc_forum.infra.exceptions;

public class NotFoundException extends BusinessRuntimeException{
  public NotFoundException() {
    super(SysCode.NOT_FOUND);
  }
}