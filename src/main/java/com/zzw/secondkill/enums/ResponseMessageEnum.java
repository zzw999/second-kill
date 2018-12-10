package com.zzw.secondkill.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ResponseMessageEnum {
    SUCCESS(200,"success"),
    FAIL(500,"服务端异常"),
    BIND_ERROR(500101,"参数校验异常：%s");
    private Integer code;
    private String message;


}
