package com.example.demo;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.http.ResponseEntity;
import  org.springframework.web.servlet.NoHandlerFoundException;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice // 这是一个神奇的注解，它会监控所有 Controller
public class GlobalExceptionHandler {


    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Map<String,Object>>handleRuntime(RuntimeException ex) {
        Map<String,Object> body = new HashMap<>();
        body.put("success",false);
        body.put("message","业务处理出错");
        body.put("error",ex.getMessage());
        return ResponseEntity.status(500).body(body);
    }

    // 1. 捕获所有未知的系统错误
//    @ExceptionHandler(Exception.class) 这个太强 是万能拦截器
//    因为太霸道 先前打不开Swagger  一直被拦截
//    public ResponseEntity<Map<String, Object>> handleAllExceptions(Exception ex) {
//        Map<String, Object> body = new HashMap<>();
//        body.put("success", false);
//        body.put("message", "服务器开小差了，请稍后再试");
//        body.put("error", ex.getMessage()); // 调试用
//
//        System.err.println("【系统异常】: " + ex.getMessage());
//        return ResponseEntity.status(500).body(body);
//    }

    // 2. 专门捕获文件过大的错误 (Day 16 的坑)
    @ExceptionHandler(org.springframework.web.multipart.MaxUploadSizeExceededException.class)
    public ResponseEntity<Map<String, Object>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, Object> body = new HashMap<>();
        body.put("success", false);
        String msg = ex.getBindingResult().getAllErrors().get(0).getDefaultMessage();
        body.put("message", msg);
        return ResponseEntity.status(400).body(body);
    }
}