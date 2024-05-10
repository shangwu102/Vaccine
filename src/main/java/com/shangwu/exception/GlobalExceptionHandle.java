package com.shangwu.exception;


import com.shangwu.pojo.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandle {
    @ExceptionHandler(Exception.class)
    public Result error() {
        return Result.error("操作失败");
    }
}
