package com.huh.ssm.dao.impl;

import com.huh.ssm.dao.BaseDao;
import com.huh.ssm.dao.CommonDao;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerDao<Customer> extends CommonDao implements BaseDao<Customer> {

    public void insert(Customer customer) {
        this.getSqlSession().insert("customer.insert", customer);
    }

    public int update(Customer customer) {
        return this.getSqlSession().update("customer.update", customer);
    }

    public int delete(Integer id) {
        return this.getSqlSession().delete("customer.delete", id);
    }

    public Customer selectOne(String firstName) {
        return this.getSqlSession().selectOne("customer.selectOne", firstName);
    }

    public List<Customer> selectAll() {
        return null;
    }

    public int getCount() {
        return (Integer) this.getSqlSession().selectOne("customer.count");
    }

    public List<Customer> selectPage(int offset, int limit) {
        return this.getSqlSession().selectList("customer.selectPage", new RowBounds(offset, limit));
    }

}
