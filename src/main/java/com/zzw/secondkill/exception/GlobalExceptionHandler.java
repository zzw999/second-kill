package com.zzw.secondkill.exception;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.zzw.secondkill.enums.ResponseMessageEnum;
import com.zzw.secondkill.vo.ResponseVO;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {
	@ExceptionHandler(value=Exception.class)
	public ResponseVO<String> exceptionHandler(HttpServletRequest request, Exception e){
		e.printStackTrace();
		if(e instanceof GlobalException) {
			GlobalException ex = (GlobalException)e;
			return ResponseVO.fail(ex.getResponseMesageEnum());
		}else if(e instanceof BindException) {
			BindException ex = (BindException)e;
			List<ObjectError> errors = ex.getAllErrors();
			ObjectError error = errors.get(0);
			String msg = error.getDefaultMessage();
			int code = ResponseMessageEnum.BIND_ERROR.getCode();
			String message = ResponseMessageEnum.BIND_ERROR.getMessage();
			message = String.format(message,msg);
			return ResponseVO.fail(code,message);
		}else {
			return ResponseVO.fail(ResponseMessageEnum.FAIL);
		}
	}
}
