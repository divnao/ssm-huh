package com.huh.ssm.service.impl;

import com.huh.ssm.dao.BaseDao;
import com.huh.ssm.domain.Customer;
import com.huh.ssm.service.CustomerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("customerService")
public class CustomerServiceImpl extends  BaseServiceImpl<Customer>  implements CustomerService {

    /**
     * the purpose of 'Override' setDao function is injecting a specified 'dao'.
     */
    @Resource(name = "customerDao")
    @Override
    public void setDao(BaseDao dao) {
        super.setDao(dao);
    }
}
