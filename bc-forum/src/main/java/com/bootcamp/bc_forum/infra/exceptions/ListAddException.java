package com.bootcamp.bc_forum.infra.exceptions;

public class ListAddException extends BusinessRuntimeException {

  public ListAddException( ) {
    super(SysCode.LIST_ADD_FAIL);
  }

}
