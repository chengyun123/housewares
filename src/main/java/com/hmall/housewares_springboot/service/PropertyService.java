package com.hmall.housewares_springboot.service;
import java.util.List;

import com.hmall.housewares_springboot.dao.PropertyDAO;
import com.hmall.housewares_springboot.pojo.Category;
import com.hmall.housewares_springboot.pojo.Property;
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
public class PropertyService {

    @Autowired
    PropertyDAO propertyDAO;
    @Autowired CategoryService categoryService;

    public void add(Property bean) {
        propertyDAO.save(bean);
    }

    public void delete(int id) {
        propertyDAO.deleteById(id);
    }

    public Property get(int id) {
        return propertyDAO.findById(id).orElse(null);
    }

    public void update(Property bean) {
        propertyDAO.save(bean);
    }

    public PageNavigator<Property> list(int cid, int start, int size,int navigatePages) {
        Category category = categoryService.get(cid);

        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = PageRequest.of(start, size, sort);

        Page<Property> pageFromJPA =propertyDAO.findByCategory(category,pageable);

        return new PageNavigator<>(pageFromJPA,navigatePages);

    }

    public List<Property> listByCategory(Category category){
        return propertyDAO.findByCategory(category);
    }

}

