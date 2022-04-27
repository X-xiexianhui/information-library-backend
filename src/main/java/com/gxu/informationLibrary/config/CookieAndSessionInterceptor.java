package com.gxu.informationLibrary.config;

import com.alibaba.fastjson.JSONObject;
import com.gxu.informationLibrary.entity.response;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import static com.gxu.informationLibrary.util.utils.getCookieByName;
@Component
public class CookieAndSessionInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(@NotNull HttpServletRequest request, @NotNull HttpServletResponse response, @NotNull Object handler) throws Exception {
        String cookie=getCookieByName(request,"loginCookie");
        if (cookie == null){
            responseFunction(response);
            return false;
        }
        String []cookieValue=cookie.split(";");
        String user_id = cookieValue[1];
        ValueOperations<String,String> ops = new StringRedisTemplate().opsForValue();
        String cookieCache=ops.get("loginCookie_"+user_id);

        return cookieCache != null && cookieCache.equals(cookie);
    }
    @Override
    public void postHandle(@NotNull HttpServletRequest request, @NotNull HttpServletResponse response, @NotNull Object handler, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(@NotNull HttpServletRequest request, @NotNull HttpServletResponse response, @NotNull Object handler, Exception ex) throws Exception {
    }
    private void responseFunction(HttpServletResponse response) throws IOException {
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Cache-Control", "no-cache");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        JSONObject json = (JSONObject) JSONObject.toJSON(new response<>(403,"未登录，请重新登录",""));
        response.getWriter().println(json);
        response.getWriter().flush();
    }
}
