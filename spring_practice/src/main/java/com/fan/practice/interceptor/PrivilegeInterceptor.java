package com.fan.practice.interceptor;

import com.fan.practice.domain.User;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class PrivilegeInterceptor implements HandlerInterceptor {

    /**
     * 判断用户是否登录, 实现原理: 判断session中有没有user
     *
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        if (user == null) {
            //没有登录
            response.sendRedirect(request.getContextPath() + "/login.jsp");
            return false;
        }

        return true;
    }
}
