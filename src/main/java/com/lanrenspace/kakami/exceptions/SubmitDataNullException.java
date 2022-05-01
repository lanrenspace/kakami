package com.lanrenspace.kakami.exceptions;

/**
 * @Author lanrenspace@163.com
 * @Description: 提交数据为空
 **/
public class SubmitDataNullException extends RuntimeException {

    public SubmitDataNullException(String errorMsg) {
        super(errorMsg);
    }

}
