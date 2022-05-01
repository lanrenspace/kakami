package com.lanrenspace.kakami.utils;

import com.lanrenspace.kakami.exceptions.ExceptionDef;
import com.lanrenspace.kakami.exceptions.ServiceException;
import org.springframework.http.HttpStatus;
import org.springframework.util.ObjectUtils;

/**
 * @Author lanrenspace@163.com
 * @Description:
 **/
public class AssertUtils {

    public static void isTrue(boolean expression, String errorMsg) {
        isTrue(expression, HttpStatus.INTERNAL_SERVER_ERROR.value(), errorMsg);
    }

    public static void isTrue(boolean expression, Integer errorCode) {
        isTrue(expression, errorCode, HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
    }

    /**
     * 基础断言
     *
     * @param expression 条件
     * @param errorCode  错误编码
     * @param errorMsg   错误消息
     * @return
     */
    public static void isTrue(boolean expression, Integer errorCode, String errorMsg) {
        if (expression) {
            throw new ServiceException(errorCode, errorMsg);
        }
    }


    /**
     * 对象为空
     *
     * @param object
     * @param errorMsg
     */
    public static void isEmpty(Object object, String errorMsg) {
        isEmpty(object, ExceptionDef.PARAMS_IS_NULL.getCode(), errorMsg);
    }


    public static void isEmpty(Object object, Integer errorCode, String errorMsg) {
        isTrue(ObjectUtils.isEmpty(object), errorCode, errorMsg);
    }

    public static void isEmpty(Object object) {
        isEmpty(object, ExceptionDef.PARAMS_IS_NULL.getCode(), ExceptionDef.PARAMS_IS_NULL.getMsg());
    }

    public static void isReqEmpty(Object object, String errorMsg) {
        isEmpty(object, ExceptionDef.REQ_PARAMS_IS_NULL.getCode(), errorMsg);
    }

    public static void isReqEmpty(Object object) {
        isEmpty(object, ExceptionDef.REQ_PARAMS_IS_NULL.getCode(), ExceptionDef.REQ_PARAMS_IS_NULL.getMsg());
    }
}
