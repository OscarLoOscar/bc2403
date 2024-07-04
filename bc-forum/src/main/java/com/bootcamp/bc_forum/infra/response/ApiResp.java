package com.bootcamp.bc_forum.infra.response;

import java.util.List;
import com.bootcamp.bc_forum.infra.exceptions.BusinessException;
import com.bootcamp.bc_forum.infra.exceptions.SysCode;
import lombok.Getter;

@Getter
public class ApiResp<T> {

  private int code;
  private String message;
  private List<T> data;

  public ApiResp(ApiRespBuilder<T> builder) {
    this.code = builder.code;
    this.message = builder.message;
    this.data = builder.data;
  }

  public static <T> ApiRespBuilder<T> builder() {
    return new ApiRespBuilder<>();
  }

  public static class ApiRespBuilder<T> {
    private int code;
    private String message;
    private List<T> data;

    public ApiRespBuilder<T> ok() {
      this.code = SysCode.SUCCESS.getCode();
      this.message = SysCode.SUCCESS.getDesc();
      return this;
    }

    public ApiRespBuilder<T> error(BusinessException message) {
      this.code = message.getCode();
      this.message = message.getMessage();
      return this;
    }

    public ApiRespBuilder<T> data(List<T> data) {
      this.data = data;
      return this;
    }

    public ApiRespBuilder<T> data(T data) {
      this.data = List.of(data);
      return this;
    }

    private ApiRespBuilder<T> code(int code) {
      this.code = code;
      return this;
    }

    public ApiRespBuilder<T> message(String message) {
      this.message = message;
      return this;
    }


    public ApiResp<T> build() {
      return new ApiResp<>(this);
    }


  }


}
