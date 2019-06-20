package com.hmall.housewares_springboot.dao;

import java.util.List;

import com.hmall.housewares_springboot.pojo.Order;
import com.hmall.housewares_springboot.pojo.OrderItem;
import com.hmall.housewares_springboot.pojo.Product;
import com.hmall.housewares_springboot.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemDAO extends JpaRepository<OrderItem,Integer>{
        List<OrderItem> findByOrderOrderByIdDesc(Order order);
        List<OrderItem> findByProduct(Product product);
        List<OrderItem> findByUserAndOrderIsNull(User user);
}
