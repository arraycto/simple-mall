package com.yqf.mall.pms.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yqf.common.result.Result;
import com.yqf.mall.pms.component.BloomRedisService;
import com.yqf.mall.pms.common.constant.PmsConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;


/**
 * @author DaniR
 * @version 1.0
 * @description 布隆过滤器拦截器
 * @createDate 2021/6/23 20:50
 */
@Slf4j
public class BloomFilterInterceptor implements HandlerInterceptor {

    @Autowired
    private BloomRedisService bloomRedisService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String currentUrl = request.getRequestURI();
        PathMatcher matcher = new AntPathMatcher();
        Map<String, String> pathVariable = matcher.extractUriTemplateVariables("/app-api/v1/products/{id}", currentUrl);
        if (bloomRedisService.includeByBloomFilter(PmsConstants.PRODUCT_REDIS_BLOOM_FILTER, pathVariable.get("id"))) {
            return true;
        }

        response.setHeader("Content-Type", "application/json");
        response.setCharacterEncoding("UTF-8");
        String result = new ObjectMapper().writeValueAsString(Result.failed("产品不存在!"));
        response.getWriter().print(result);
        return false;

    }

}
