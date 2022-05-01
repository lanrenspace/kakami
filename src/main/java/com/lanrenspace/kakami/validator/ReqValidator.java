package com.lanrenspace.kakami.validator;


import com.lanrenspace.kakami.dto.RegisterDTO;
import com.lanrenspace.kakami.exceptions.ExceptionDef;
import com.lanrenspace.kakami.exceptions.ServiceException;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.stream.Collectors;

/**
 * @Author lanrenspace@163.com
 * @Description:
 **/
public class ReqValidator {

    /**
     * 注册校验执行校验
     */
    public static void registerDTO(RegisterDTO registerDTO) {
        Errors errors = new BeanPropertyBindingResult(registerDTO, RegisterDTO.class.getName());
        ValidationUtils.invokeValidator(new Validator() {
            @Override
            public boolean supports(Class<?> clazz) {
                return RegisterDTO.class.isAssignableFrom(clazz);
            }

            @Override
            public void validate(Object target, Errors errors) {
                ValidationUtils.rejectIfEmpty(errors, "email", "email");
                ValidationUtils.rejectIfEmpty(errors, "pwd", "pwd");
                ValidationUtils.rejectIfEmpty(errors, "emailCode", "emailCode");
            }
        }, registerDTO, errors);
        if (errors.hasErrors()) {
            rsp(errors);
        }
    }


    /**
     * 响应
     */
    private static void rsp(String msg, Errors errors) {
        ExceptionDef reqParamsIsNull = ExceptionDef.REQ_PARAMS_IS_NULL;
        String rspMsg = msg;
        if (ObjectUtils.isEmpty(rspMsg)) {
            rspMsg = String.format("[%s]", errors.getAllErrors().parallelStream().map(DefaultMessageSourceResolvable::getCode).collect(Collectors.joining(":"))) + reqParamsIsNull.getMsg();
        }
        throw new ServiceException(reqParamsIsNull.getCode(), rspMsg);
    }


    /**
     * 响应
     */
    private static void rsp(Errors errors) {
        rsp(null, errors);
    }
}
