package com.hmall.housewares_springboot.dao;

import com.hmall.housewares_springboot.pojo.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryDAO extends JpaRepository<Category,Integer> {

}
