package com.hmall.housewares_springboot.dao;
import java.util.List;

import com.hmall.housewares_springboot.pojo.Product;
import com.hmall.housewares_springboot.pojo.Property;
import com.hmall.housewares_springboot.pojo.PropertyValue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropertyValueDAO extends JpaRepository<PropertyValue,Integer>{

    List<PropertyValue> findByProductOrderByIdDesc(Product product);
    PropertyValue getByPropertyAndProduct(Property property, Product product);
}
