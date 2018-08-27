package com.huh.ssm.service.impl;

import com.huh.ssm.dao.BaseDao;
import com.huh.ssm.service.BaseService;

import java.util.List;

public abstract class BaseServiceImpl<T> implements BaseService<T> {

    private BaseDao<T> dao;

    /**
     * the feature of 'setDao' is sub-class inject a specified dao.
     */
    public void setDao(BaseDao<T> dao) {
        this.dao = dao;
    }

    public void insert(T t) {
        dao.insert(t);
    }

    public int update(T t) {
        return dao.update(t);
    }

    public int delete(Integer id) {
        return dao.delete(id);
    }

    public T selectOne(String t) {
        return dao.selectOne(t);
    }

    public List<T> selectAll() {
        return dao.selectAll();
    }

    public int getCount() {
        return dao.getCount();
    }

    public List<T> selectPage(int offset, int limit) {
        return dao.selectPage(offset, limit);
    }

}
