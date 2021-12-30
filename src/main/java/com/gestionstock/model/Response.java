package com.gestionstock.model;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.experimental.SuperBuilder;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.Map;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

/**
 * @author  : CHARRIK ALAE-EDDINE
 * @version : 1.0
 * @since 12/24/2021
 */
@Data
@SuperBuilder
@JsonInclude(NON_NULL)
public class Response {
    protected LocalDateTime timeStamp;
    protected int statusCode;
    protected HttpStatus status;
    protected  String reason;
    protected String message;
    protected String developerMessage;
    protected Map<?,?> data ;
}
