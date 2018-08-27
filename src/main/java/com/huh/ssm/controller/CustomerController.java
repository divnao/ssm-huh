package com.huh.ssm.controller;


import com.huh.ssm.domain.Address;
import com.huh.ssm.domain.Customer;
import com.huh.ssm.service.CustomerService;
import com.huh.ssm.util.Utils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class CustomerController {

    @Resource(name = "customerService")
    private CustomerService customerService;

    @RequestMapping("/getCustomerList")
    @ResponseBody
    public Map<String, Object> getCustomerList(@RequestParam("pageNum") int pageNum,
                                               @RequestParam("pageSize") int pageSize,
                                               HttpSession session) {
        Map<String, Object> map = new HashMap<String, Object>(7);
        //　获取结果总数
        int totalResult = customerService.getCount();

        // 计算偏移量
        if (pageNum == 0) {
            pageNum = 1;
        }
        int offset = (pageNum - 1) * pageSize;

        // 获取分页结果
        List<Customer> customers = customerService.selectPage(offset, pageSize);

        // 计算总页数
        int totalPage = Utils.getTotalPage(totalResult, pageSize);

        // 结果封装
        map.put("totalResult", totalResult);
        map.put("totalPage", totalPage);
        map.put("currentPage", pageNum);
        map.put("customerList", customers);
        map.put("currentUser", session.getAttribute("user"));

        //结果返回
        return map;
    }

    @RequestMapping("/doModify")
    @ResponseBody
    public Map<String, Object> doModify(@RequestParam("customerId") int customerId,
                                        @RequestParam("firstName") String firstName,
                                        @RequestParam("lastName") String lastName,
                                        @RequestParam("email") String email,
                                        @RequestParam("addressId") int addressId,
                                        @RequestParam("pageNum") int pageNum,
                                        @RequestParam("pageSize") int pageSize,
                                        HttpSession session) {
        // now
        Date now = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Customer customer = new Customer();
        Address address = new Address();
        String lastUpdate = ft.format(now);

        // bind param
        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        customer.setEmail(email);
        customer.setLastUpdate(lastUpdate);
        address.setAddressId(addressId);
        customer.setAddress(address);
        customer.setCustomerId(customerId);

        // update
        customerService.update(customer);

        // return the updated page which user requested.
        Map<String, Object> map = getCustomerList(pageNum, pageSize, session);
        return map;
    }

    @RequestMapping("/doInsert")
    @ResponseBody
    public Map<String, Object> doInsert(
                                        @RequestParam("firstName") String firstName,
                                        @RequestParam("lastName") String lastName,
                                        @RequestParam("email") String email,
                                        @RequestParam("address") String address,
                                        @RequestParam("pageNum") int pageNum,
                                        @RequestParam("pageSize") int pageSize,
                                        HttpSession session) {
        // now
        Date now = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Customer customer = new Customer();
        Address a = new Address();
        a.setAddress(address);
        String lastUpdate = ft.format(now);

        // bind param
        customer.setAddress(a);
        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        customer.setEmail(email);
        customer.setLastUpdate(lastUpdate);
        customer.setStoreId(1);
        customer.setCreateDate(lastUpdate);
        customer.setActive(1);

        // insert
        customerService.insert(customer);

        Map<String, Object> map = getCustomerList(pageNum, pageSize, session);
        return map;
    }

    @ResponseBody
    @RequestMapping("/doDelete")
    public Map<String, Object> doDelete(@RequestParam("customerId") int customerId,
                                        @RequestParam("pageNum") int pageNum,
                                        @RequestParam("pageSize") int pageSize) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("pageNum", pageNum);
        map.put("pageSize", pageSize);
        int line = 0;
        try {
            line = customerService.delete(customerId);
            map.put("data", line);
        } catch (Exception e){
            String ex = e.getClass().toString();
            map.put("data", ex.substring(ex.lastIndexOf('.') + 1, ex.length()));
        } finally {
            return map;
        }
    }

}
