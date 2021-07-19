package com.sap.spring.mongodb.modal;

import java.util.Date;

public class ExceptionResponse {
private Date timestamp;
private String message;
private String details;

    public ExceptionResponse(Date timestamp, String message, String details) {
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }

    public ExceptionResponse() {
    }

    public Date getTimestamp() {
        return timestamp;
    }


    public String getMessage() {
        return message;
    }



    public String getDetails() {
        return details;
    }


}
