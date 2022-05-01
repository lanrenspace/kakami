package com.lanrenspace.kakami.exceptions;

/**
 * @Author lanrenspace@163.com
 * @Description: 请求无权限
 **/
public class RequestNoPermissionException extends RuntimeException {

    public RequestNoPermissionException(String errorMsg) {
        super(errorMsg);
    }

}
