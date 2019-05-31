package com.bupt.crud.controller;

import com.bupt.crud.entities.Employee;
import com.bupt.crud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
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


    @Autowired
    EmployeeService employeeService;

    //@RequestMapping(value = "/user/login",method = RequestMethod.POST)
    @PostMapping("/user/login")
    public String login(@RequestParam("username")String username, @RequestParam("password")String password,
                        Map<String,Object> map, HttpSession httpSession) {

        Employee employee = employeeService.getEmpbyName(username);
        if (employee!=null) {
            if (password.equals(employee.getPassword())) {
                //登陆成功，为了防止重复提交表单，可以重定向到主页
                httpSession.setAttribute("loginUser", username);
                return "redirect:/main.html";
            } else {
                map.put("msg", "密码错误");
                return "login";
            }
        } else {
            map.put("msg", "用户名不存在");
            return "login";
        }
    }
}
