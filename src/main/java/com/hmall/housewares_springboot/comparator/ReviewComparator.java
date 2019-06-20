package com.hmall.housewares_springboot.comparator;

import com.hmall.housewares_springboot.pojo.Product;

import java.util.Comparator;

public class ReviewComparator implements Comparator<Product> {

    @Override
    public int compare(Product p1, Product p2) {
        return p2.getReviewCount()-p1.getReviewCount();
    }
}
