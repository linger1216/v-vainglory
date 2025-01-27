package com.vainglory.advice;

import com.vainglory.common.R;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class ControllerException {
    @ExceptionHandler({BindException.class})
    public R MethodArgumentNotValidExceptionHandler(BindException e) {
        // 从异常对象中拿到ObjectError对象
        List<ObjectError> allErrors = e.getBindingResult().getAllErrors();
//        String defaultMessage = objectError.getDefaultMessage();
        return new R(500, "");
    }
}
