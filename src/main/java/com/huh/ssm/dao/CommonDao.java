package com.huh.ssm.dao;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import javax.annotation.Resource;

public class CommonDao extends SqlSessionDaoSupport {

    @Override
    @Resource
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }
}
