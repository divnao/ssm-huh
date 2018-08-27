package com.huh.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

    //BETTY
    //WHITE

    @RequestMapping(value = {"/", "/home"})
    public String goHome() {
        return "index";
    }

    @RequestMapping(value = "/logOut")
    public String logOut(HttpSession session) {
        session.removeAttribute("user");
        return "index";
    }

}
