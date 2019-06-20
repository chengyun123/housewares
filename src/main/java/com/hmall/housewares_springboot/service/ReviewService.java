package com.hmall.housewares_springboot.service;

import java.util.List;

import com.hmall.housewares_springboot.dao.ReviewDAO;
import com.hmall.housewares_springboot.pojo.Product;
import com.hmall.housewares_springboot.pojo.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {

    @Autowired
    ReviewDAO reviewDAO;
    @Autowired ProductService productService;

    public void add(Review review) {
        reviewDAO.save(review);
    }

    public List<Review> list(Product product){
        List<Review> result =  reviewDAO.findByProductOrderByIdDesc(product);
        return result;
    }

    public int getCount(Product product) {
        return reviewDAO.countByProduct(product);
    }

}
