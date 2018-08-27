package com.huh.ssm.dao;

import java.util.List;

public interface BaseDao<T> {

    public void insert(T t);

    public int update(T t);

    public int delete(Integer id);

    public T selectOne(String firstName);

    public List<T> selectAll();

    public int getCount();

    public List<T> selectPage(int offset, int limit);

}



