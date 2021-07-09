package com.yqf.admin.api;

import com.yqf.admin.pojo.entity.SysOauthClient;

import com.yqf.common.result.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "admin", contextId = "oauth-client")
@Component
public interface OAuthClientFeignClient {

    @GetMapping("/api/v1/oauth-clients/{clientId}")
    Result<SysOauthClient> getOAuthClientById(@PathVariable String clientId);
}
