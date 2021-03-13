package com.brunoIgarzabal.mmr.resources.exceptions;

import java.io.Serializable;

public class StandardError implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer status;
    private String message;
    private Long timesStamp;

    public StandardError() {}

    public StandardError(Integer status, String message, Long timesStamp) {
        this.status = status;
        this.message = message;
        this.timesStamp = timesStamp;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getTimesStamp() {
        return timesStamp;
    }

    public void setTimesStamp(Long timesStamp) {
        this.timesStamp = timesStamp;
    }
}
