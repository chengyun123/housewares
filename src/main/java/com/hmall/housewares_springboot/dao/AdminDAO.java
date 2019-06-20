package com.hmall.housewares_springboot.dao;

import com.hmall.housewares_springboot.pojo.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminDAO extends JpaRepository<Admin,Integer> {
    Admin getByNameAndPassword(String name, String password);
}
