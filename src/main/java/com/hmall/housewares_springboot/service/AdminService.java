package com.hmall.housewares_springboot.service;

import com.hmall.housewares_springboot.dao.AdminDAO;
import com.hmall.housewares_springboot.pojo.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    @Autowired
    AdminDAO adminDAO;

    public Admin get(String name,String password){
        return adminDAO.getByNameAndPassword(name,password);
    }
}
