package com.zzw.secondkill.vo;

import com.zzw.secondkill.enums.ResponseMessageEnum;
import lombok.Data;

@Data
public class ResponseVO<T> {

    private Integer code;

    private String message;

    private T data;

    public static  <T> ResponseVO<T> success(T data){
        return new ResponseVO<T>(ResponseMessageEnum.SUCCESS.getCode(),ResponseMessageEnum.SUCCESS.getMessage(),data);
    }

    public static  <T> ResponseVO<T> fail(ResponseMessageEnum message){
        return new ResponseVO<T>(message.getCode(),message.getMessage(),null);
    }

    public static  <T> ResponseVO<T> fail(int code, String message){
        return new ResponseVO<T>(code,message,null);
    }

    private ResponseVO(Integer code, String message,T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

}
