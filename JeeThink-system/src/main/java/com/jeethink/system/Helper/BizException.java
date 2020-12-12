package com.jeethink.system.Helper;

import lombok.Data;

@Data
public class BizException extends RuntimeException {
    //业务异常
    private int status = 1;
    private String message;

    public BizException(String message) {
        super(message);

        this.message = message;
    }

    public BizException(int status,String message) {
        super(message);

        this.status = status;
        this.message = message;
    }

    public BizException(int status,String message, Throwable able) {
        super(message,able);

        this.status = status;
        this.message = message;
    }

    public BizException(String message, Throwable able) {
        super(message,able);

        this.message = message;
    }
}