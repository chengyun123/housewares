package com.hmall.housewares_springboot.dao;
import java.util.List;

import com.hmall.housewares_springboot.pojo.Order;
import com.hmall.housewares_springboot.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
public interface OrderDAO extends JpaRepository<Order,Integer>{
    public List<Order> findByUserAndStatusNotOrderByIdDesc(User user, String status);
}
