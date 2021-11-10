package it.apuliadigitalmaker.dev2022.filmmanager.utility;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import it.apuliadigitalmaker.dev2022.filmmanager.common.CommonResponseCode;
import it.apuliadigitalmaker.dev2022.filmmanager.responseDto.BaseResponseBody;

public class ResponseGenerator {
	
	public static <T> ResponseEntity<?> generateResponse(T payload, CommonResponseCode respCode, boolean success, HttpStatus httpStatus){
		
		return new ResponseEntity<>(
				new BaseResponseBody<>(success, respCode.getMessage(), respCode.getResponseCode(), payload),
				httpStatus
		);
		
	}

}
