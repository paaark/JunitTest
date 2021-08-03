package com.example.junittest.common.response.dto;

import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter
public class ResponseDto<T> {

    private int status;
    private String message;
    private T data;
    private LocalDateTime timestamp;

    @Builder
    public ResponseDto(HttpStatus httpStatus,T data){
        this.status = httpStatus.value();
        this.message = httpStatus.getReasonPhrase();
        this.data = data;
        this.timestamp = LocalDateTime.now();
    }
}
