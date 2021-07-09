package com.yqf.admin.api.fallback;

import com.yqf.admin.api.UserFeignClient;
import com.yqf.admin.pojo.entity.SysUser;
import com.yqf.common.result.Result;
import com.yqf.common.result.ResultCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author haoxr
 * @createTime 2021/4/24 21:30
 */
@Component
@Slf4j
public class UserFeignFallbackClient implements UserFeignClient {

    @Override
    public Result<SysUser> getUserByUsername(String username) {
        log.error("feign远程调用系统用户服务异常后的降级方法");
        return Result.failed(ResultCode.DEGRADATION);
    }
}
