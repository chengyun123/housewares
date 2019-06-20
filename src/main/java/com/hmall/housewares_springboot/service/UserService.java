package com.hmall.housewares_springboot.service;

import com.hmall.housewares_springboot.dao.UserDAO;
import com.hmall.housewares_springboot.pojo.User;
import com.hmall.housewares_springboot.tool.PageNavigator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
@Service
public class UserService {

    @Autowired
    UserDAO userDAO;

    public PageNavigator<User> list(int start, int size, int navigatePages) {
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = PageRequest.of(start, size,sort);
        Page pageFromJPA =userDAO.findAll(pageable);
        return new PageNavigator<>(pageFromJPA,navigatePages);
    }

    public User getByName(String name) {
        return userDAO.findByName(name);
    }

    public boolean isExist(String name) {
        User user = getByName(name);
        return null!=user;
    }
    public void add(User user) {
        userDAO.save(user);
    }

    public User get(String name, String password) {
        return userDAO.getByNameAndPassword(name,password);
    }


}

