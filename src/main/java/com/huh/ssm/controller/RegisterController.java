package com.huh.ssm.controller;


import com.huh.ssm.domain.Customer;
import com.huh.ssm.service.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * do login
 *
 * @author huh
 */
@Controller
public class RegisterController {

    @Resource(name = "customerService")
    private CustomerService customerService;

    @RequestMapping("/doReg")
    public String toRegister(@RequestParam("username") String username, @RequestParam("password") String password, HttpSession session) {
        Customer customer = customerService.selectOne(username);
        if (customer != null) {
            if (customer.getLastName().trim().equals(password.trim())) {
                session.setAttribute("user", customer.getFirstName().trim());
                return "/customer_list";
            } else {
                return "index";
            }
        } else {
            return "index";
        }
    }

}
