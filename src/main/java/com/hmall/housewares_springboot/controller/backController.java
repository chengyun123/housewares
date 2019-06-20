package com.hmall.housewares_springboot.controller;

import com.hmall.housewares_springboot.pojo.Admin;
import com.hmall.housewares_springboot.service.AdminService;
import com.hmall.housewares_springboot.tool.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.HtmlUtils;

import javax.servlet.http.HttpSession;

@RestController
public class backController {
    @Autowired
    AdminService adminService;

    @PostMapping("/backlogin")
    public Object login(@RequestBody Admin adminParam, HttpSession session) {
        String name =  adminParam.getName();
        name = HtmlUtils.htmlEscape(name);

        Admin admin =adminService.get(name,adminParam.getPassword());
        if(null==admin){
            String message ="账号密码错误";
            return Result.fail(message);
        }
        else{
            session.setAttribute("admin", admin);
            return Result.success();
        }
    }
}
