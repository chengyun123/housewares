package com.hmall.housewares_springboot.dao;
import java.util.List;

import com.hmall.housewares_springboot.pojo.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import com.hmall.housewares_springboot.pojo.Product;

public interface ReviewDAO extends JpaRepository<Review,Integer>{

    List<Review> findByProductOrderByIdDesc(Product product);
    int countByProduct(Product product);

}
