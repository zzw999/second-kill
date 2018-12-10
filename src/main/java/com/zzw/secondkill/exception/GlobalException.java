package com.zzw.secondkill.exception;


import com.zzw.secondkill.enums.ResponseMessageEnum;

public class GlobalException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	private ResponseMessageEnum messageEnum;
	
	public GlobalException(ResponseMessageEnum messageEnum) {
		super(messageEnum.toString());
		this.messageEnum = messageEnum;
	}

	public ResponseMessageEnum getResponseMesageEnum() {
		return messageEnum;
	}

}
