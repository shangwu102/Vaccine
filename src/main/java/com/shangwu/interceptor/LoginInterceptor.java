package com.shangwu.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.shangwu.pojo.Result;
import com.shangwu.utils.JwtUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        // 获取请求的url
//        String url = request.getRequestURL().toString();
//        // 判断请求url中是否包含login，如果包含说明是登陆操作，放行
//        if (url.contains("login")) {
//            return true;
//        }
        // 获取请求头中的令牌
        String jwt = request.getHeader("token");
        // 判断令牌是否存在，如果不存在，返回错误结果
        if (!StringUtils.hasLength(jwt)) {
            log.info("token为空");
            Result error = Result.error("NOT_LOGIN");
            // 手动对象转化为json
            String jsonString = JSONObject.toJSONString(error);
            response.getWriter().write(jsonString);
            return false;
        }
        // 解析token，如果解析失败，返回错误结果(未登录)
        try {
            JwtUtils.parseJWT(jwt);
        } catch (Exception e) {
            log.info("解析令牌失败");
            Result error = Result.error("NOT_LOGIN");
            // 手动对象转化为json
            String jsonString = JSONObject.toJSONString(error);
            response.getWriter().write(jsonString);
            return false;
        }
        return true; // 放行
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }

}
