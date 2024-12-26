package com.ra.sesson02.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class ResponseWrapper <T>{
    private HttpStatus status;
    private int code;
    private T errorMessage;
}
