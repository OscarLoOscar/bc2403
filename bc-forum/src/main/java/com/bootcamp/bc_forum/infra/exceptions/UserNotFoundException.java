package com.bootcamp.bc_forum.infra.exceptions;

public class UserNotFoundException extends BusinessRuntimeException {
  public UserNotFoundException() {
    super(SysCode.USER_ID_NOT_FOUND);
  }
}
