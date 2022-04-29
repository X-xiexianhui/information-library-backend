package com.gxu.informationLibrary.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.gxu.informationLibrary.entity.response;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import static com.gxu.informationLibrary.util.utils.getCookieByName;
@Slf4j
@Component
public class CookieAndSessionInterceptor implements HandlerInterceptor {
    @Autowired
    private StringRedisTemplate redisTemplate;

    @Override
    public boolean preHandle(@NotNull HttpServletRequest request, @NotNull HttpServletResponse response, @NotNull Object handler) throws Exception {
        if ("OPTIONS".equals(request.getMethod().toLowerCase())){
            return true;
        }
        String cookie = getCookieByName(request, "loginCookie");
        if (cookie == null) {
            com.gxu.informationLibrary.entity.response<String>data=new response<>(401,"未登录，请先登录","");
            JSONObject json= (JSONObject) JSON.toJSON(data);
            response.getWriter().print(json);
            response.getWriter().flush();
            return false;
        }
        String[] cookieValue = cookie.split("_");
        String user_id = cookieValue[1];

        ValueOperations<String, String> ops = this.redisTemplate.opsForValue();
        String cookieCache = ops.get("loginCookie_" + user_id);
        if (cookieCache == null || !cookieCache.equals(cookie)) {
            com.gxu.informationLibrary.entity.response<String>data=new response<>(403,"密码错误","");
            JSONObject json= (JSONObject) JSON.toJSON(data);
            response.getWriter().print(json);
            response.getWriter().flush();
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(@NotNull HttpServletRequest request, @NotNull HttpServletResponse response, @NotNull Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request,response,handler,modelAndView);
    }

    @Override
    public void afterCompletion(@NotNull HttpServletRequest request, @NotNull HttpServletResponse response, @NotNull Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request,response,handler,ex);
    }
}
