package com.yqf.mall.sms.controller.app;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.yqf.common.result.Result;
import com.yqf.mall.sms.pojo.SmsAdvert;
import com.yqf.mall.sms.service.ISmsAdvertService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "【移动端】营销广告")
@RestController("APPAdvertController")
@RequestMapping("/app-api/v1/adverts")
@Slf4j
@AllArgsConstructor
public class AdvertController {

    private ISmsAdvertService iSmsAdvertService;

    @ApiOperation(value = "列表分页")
    @GetMapping
    public Result list() {
        LambdaQueryWrapper<SmsAdvert> queryWrapper = new LambdaQueryWrapper<SmsAdvert>()
                .orderByAsc(SmsAdvert::getSort);
        List<SmsAdvert> data = iSmsAdvertService.list(queryWrapper);
        return Result.success(data);
    }
}
