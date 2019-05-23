package com.bupt.crud.controller;

import com.bupt.crud.exception.UserNotExistException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class MyExceptionHandler {
    //1,浏览器和客户端返回的都是json数据
//    @ResponseBody
//    @ExceptionHandler(UserNotExistException.class)
//    public Map<String,Object> handlerException(Exception e){
//
//        Map<String,Object> map = new HashMap<>();
//        map.put("code","user.notexist");
//        map.put("message",e.getMessage());
//        return map;
//    }


    @ExceptionHandler(UserNotExistException.class)
    public String handlerException(Exception e){

        Map<String,Object> map = new HashMap<>();
        map.put("code","user.notexist");
        map.put("message",e.getMessage());
        //转发到error
        return "forword:/error";
    }
}
