package com.gxu.informationLibrary.util;

import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Slf4j
public class utils {
    public static @NotNull String getIndexName(@NotNull List<String> fields, boolean uni) {
        StringBuilder index_name= new StringBuilder();
        for (String str:fields) {
            index_name.append(str);
            index_name.append("_");
        }
        if (uni){
            index_name.append("uni_index");
        }else {
            index_name.append("index");
        }
        return index_name.toString();
    }
    public static void setCookie(@NotNull HttpServletResponse response, String key, String value, int expiry){
        Cookie cookie = new Cookie(key, value); //key 为cookie内容名字，value为cookie 类型
        cookie.setMaxAge(expiry);       //cookie过期时间
        cookie.setHttpOnly(true);
        cookie.setPath("/");
        cookie.setSecure(false);
        response.addCookie(cookie);
    }
    public static @Nullable String getCookieByName(HttpServletRequest request, String name){
        Map<String,String> cookieMap = ReadCookieMap(request);
        return cookieMap.getOrDefault(name, null);
    }

    private static @NotNull Map<String,String> ReadCookieMap(HttpServletRequest request){
        Map<String,String> cookieMap = new HashMap<>();
        Cookie[] cookies = request.getCookies();
        log.info(String.valueOf(cookies));
        if(null!=cookies){
            for(Cookie cookie : cookies){
                cookieMap.put(cookie.getName(), cookie.getValue());
            }
        }
        return cookieMap;
    }
}
