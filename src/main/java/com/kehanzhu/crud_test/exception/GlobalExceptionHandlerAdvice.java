package com.kehanzhu.crud_test.exception;

import com.kehanzhu.crud_test.pojo.ResponseMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandlerAdvice {
    Logger logger = LoggerFactory.getLogger(GlobalExceptionHandlerAdvice.class);
    @ExceptionHandler(value = Exception.class)
    public ResponseMessage handleException(Exception e) {
        // 记录日志
        logger.error(e.getMessage(), e);
        return new ResponseMessage(500, "error", null);
    }
}
