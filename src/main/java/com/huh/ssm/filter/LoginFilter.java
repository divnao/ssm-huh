package com.huh.ssm.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


/**
 * user which has not loged in can not access system.
 *
 * @author huh
 */
public class LoginFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        HttpSession session = req.getSession(true);
        String url=req.getRequestURI();
        if ((session.getAttribute("user") != null) || url.equals("/doReg") || url.equals("/index.html") || url.equals("/static/imgs/1.png")) {
            chain.doFilter(request, response);
        } else {
            resp.sendRedirect(req.getContextPath() + "/index.html");
        }
    }

    public void destroy() {

    }
}
