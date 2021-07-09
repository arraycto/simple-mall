package com.yqf.admin.api;

import com.yqf.admin.api.fallback.UserFeignFallbackClient;
import com.yqf.admin.pojo.entity.SysUser;
import com.yqf.common.result.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "admin", fallback = UserFeignFallbackClient.class)
public interface UserFeignClient {

    @GetMapping("/api/v1/users/username/{username}")
    Result<SysUser> getUserByUsername(@PathVariable String username);
}
