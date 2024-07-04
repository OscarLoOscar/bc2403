package com.bootcamp.bc_forum.infra.exceptions;

import lombok.Getter;

@Getter
public enum SysCode {
  SUCCESS(0, "success."), //
  NOT_FOUND(1, "not found."), //
  USER_ID_NOT_FOUND(2, "User ID not found."), //
  LIST_ADD_FAIL(3, "List Add Fail."), //
  REST_TEMPLATE_ERROR(4, "RestTemplate Error."), //
  JSON_PROCESSING_ERROR(5, "Json Processing Error."), //
  ;

  private int code;
  private String desc;

  private SysCode(int code, String desc) {
    this.code = code;
    this.desc = desc;
  }
}
