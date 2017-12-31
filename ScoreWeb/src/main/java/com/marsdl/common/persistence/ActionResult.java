package com.marsdl.common.persistence;

import org.aspectj.apache.bcel.generic.ObjectType;

/**
 * @Description 操作结果类[可用于ajax返回记录对象]
 * @Author chenrui
 * @since 2017/12/31
 */
public class ActionResult {

    private boolean success;
    private Object result;
    private int code;
    private Throwable exception;
    private String message;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Throwable getException() {
        return exception;
    }

    public void setException(Throwable exception) {
        this.exception = exception;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
