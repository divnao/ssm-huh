package com.huh.ssm.dao.impl;

import com.huh.ssm.dao.BaseDao;
import com.huh.ssm.dao.CommonDao;
import com.sun.org.apache.regexp.internal.REUtil;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AddressDao<Address> extends CommonDao implements BaseDao<Address> {

    public void insert(Address address) {
        // null implement
    }

    public int update(Address address) {
        return 0;
    }

    public int delete(Integer id) {
        return 0;
    }

    public Address selectOne(String firstName) {
        return null;
    }

    public List<Address> selectAll() {
        return null;
    }

    public int getCount() {
        return 0;
    }

    public List<Address> selectPage(int offset, int limit) {
        return null;
    }

}
