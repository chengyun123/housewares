package com.hmall.housewares_springboot.controller;
import com.hmall.housewares_springboot.pojo.User;
import com.hmall.housewares_springboot.service.UserService;
import com.hmall.housewares_springboot.tool.PageNavigator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/users")
    public PageNavigator<User> list(@RequestParam(value = "start", defaultValue = "0") int start, @RequestParam(value = "size", defaultValue = "5") int size) throws Exception {
        start = start<0?0:start;
        PageNavigator<User> page = userService.list(start,size,5);
        return page;
    }

}
