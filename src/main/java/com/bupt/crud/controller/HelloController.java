package com.bupt.crud.controller;

import com.bupt.crud.exception.UserNotExistException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Map;

@Controller
public class HelloController {


//    @RequestMapping({"/","/index.html"})
//    public String index(){
//        return "login";
//    }

    @ResponseBody
    @RequestMapping("/hello")
    public String hello(@RequestParam("username") String username){
        if(username.equals("aaa")){
            throw new UserNotExistException();
        }

        return "hello";
    }

    @RequestMapping("/success")
    public String success(Map<String,Object> maps){
        maps.put("hello","宁好");
        maps.put("users", Arrays.asList("zs","ls","ww"));
        return "success";
    }
}
