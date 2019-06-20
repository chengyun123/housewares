package com.hmall.housewares_springboot.dao;
import java.util.List;

import com.hmall.housewares_springboot.pojo.Category;
import com.hmall.housewares_springboot.pojo.Property;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropertyDAO extends JpaRepository<Property,Integer>{
    Page<Property> findByCategory(Category category, Pageable pageable);
    List<Property> findByCategory(Category category);
}
