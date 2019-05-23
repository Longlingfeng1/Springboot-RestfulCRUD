package com.bupt.crud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.annotation.RequestScope;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {

    //@RequestMapping(value = "/user/login",method = RequestMethod.POST)
    @PostMapping("/user/login")
    public String login(@RequestParam("username")String username, @RequestParam("password")String password,
                        Map<String,Object> map, HttpSession httpSession){
        if(!StringUtils.isEmpty(username) && "123456".equals(password)){
            //登陆成功，为了防止重复提交表单，可以重定向到主页
            httpSession.setAttribute("loginUser",username);
            return "redirect:/main.html";
        }
        else{
            map.put("msg","用户名密码错误");
            return "login";
        }
    }
}
