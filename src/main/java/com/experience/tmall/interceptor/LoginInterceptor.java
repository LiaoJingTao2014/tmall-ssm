package com.experience.tmall.interceptor;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.experience.tmall.pojo.User;
import com.experience.tmall.service.CategoryService;
import com.experience.tmall.service.OrderItemService;

public class LoginInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    CategoryService categoryService;

    @Autowired
    OrderItemService orderItemService;

    // 在业务处理器处理请求之前被调用
    // 如果返回false
    // 从当前的拦截器往回执行所有拦截器的afterCompletion(),再退出拦截器链
    // 如果返回true
    // 执行下一个拦截器,直到所有的拦截器都执行完毕
    // 再执行被拦截的Controller
    // 然后进入拦截器链,
    // 从最后一个拦截器往回执行所有的postHandle()
    // 接着再从最后一个拦截器往回执行所有的afterCompletion()
    public boolean proHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        HttpSession session = request.getSession();
        String contextPath = session.getServletContext().getContextPath();
        String[] noNeedAuthPage = new String[] { "home", "checkLogin", "register", "loginAjax", "login", "product",
                "category", "search" };
        String uri = request.getRequestURI();
        uri = StringUtils.remove(uri, contextPath);
        if (uri.startsWith("/fore")) {
            String method = StringUtils.substringAfter(uri, "/fore");
            if (!Arrays.asList(noNeedAuthPage).contains(method)) {
                User user = (User) session.getAttribute("user");
                if (null == user) {
                    response.sendRedirect("loginPage");
                    return false;
                }
            }
        }
        return true;
    }

    // 在业务处理器处理请求执行完成后,生成视图之前执行的动作
    // 可在 modelAndView 中加入数据, 比如当前时间
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {

    }

}
