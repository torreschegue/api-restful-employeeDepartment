package com.torres.developer.exception;

import java.util.Date;

import lombok.Data;

@Data
public class ErrorObject {

	private Integer StatusCode;
	
	private String message;
	
	private Date timestamp;

}
