package com.fan.interceptorStudy.interceptors;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyInterceptor_1 implements HandlerInterceptor {

    /**
     * 方法在请求处理之前进行调用
     * @param request
     * @param response
     * @param handler
     * @return 当返回值为true时就会继续调用下一个Interceptor的preHandle方法; 当返回false时,表示请求结束, 后续的Interceptor和Controller都不会再执行
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("preHandle....");
        if("male".equals(request.getParameter("gender"))){
            //返回true代表放行, false代表不放行
            return true;
        } else {
            request.getRequestDispatcher("/error.jsp").forward(request,response);
            return false;
        }
    }

    /**
     * 在当前请求进行处理之后被调用, 前提是preHandle方法的返回值为true时才能被调用, 且它会在DispatcherServlet进行视图返回渲染之前被调用, 所以我们可以在
     * 这个方法中对Controller处理之后的ModelAndView对象进行操作
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        modelAndView.addObject("name", "Interceptor");
        System.out.println("postHandle....");
    }

    /**
     * 在整个请求结束之后, 也就是在DispatcherServlet渲染了对应的视图之后执行, 前提是preHandle方法的返回值为true时才能被调用
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion.....");
    }
}
