package com.lanrenspace.kakami.exceptions;

/**
 * @Author lanrenspace@163.com
 * @Description:
 **/
public class ServiceException extends RuntimeException {

    /**
     * 错误码
     */
    private Integer code;

    /**
     * 错误消息
     */
    private String msg;

    public ServiceException(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ServiceException(ExceptionDef exceptionDef) {
        this.code = exceptionDef.getCode();
        this.msg = exceptionDef.getMsg();
    }

    public String getMsg() {
        return msg;
    }

    public Integer getCode() {
        return code;
    }
}
