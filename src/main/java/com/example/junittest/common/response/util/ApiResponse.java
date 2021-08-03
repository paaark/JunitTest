package com.example.junittest.common.response.util;

import com.example.junittest.common.response.dto.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ApiResponse {

    public static <T> ResponseEntity<ResponseDto> success(HttpStatus status, T data, String responseUrl){
        return ResponseEntity.status(status)
                .header("Location",responseUrl)
                .body(new ResponseDto(status, data));
    }

}
