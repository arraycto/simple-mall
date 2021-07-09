package com.yqf.auth.service.impl;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.lang.Assert;
import com.yqf.auth.common.jwt.JwtGenerator;
import com.yqf.auth.domain.OAuthToken;
import com.yqf.auth.domain.UserInfo;
import com.yqf.auth.service.IAuthService;
import com.yqf.common.constant.AuthConstants;
import com.yqf.common.result.Result;
import com.yqf.common.result.ResultCode;
import com.yqf.mall.ums.api.MemberFeignClient;
import com.yqf.mall.ums.pojo.entity.UmsMember;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author haoxr
 * @description 微信小程序认证接口
 * @createTime 2021/5/20 23:37
 */
@Service
@AllArgsConstructor
public class WechatAuthServiceImpl implements IAuthService {

    private MemberFeignClient memberFeignClient;
    private WxMaService wxMaService;
    private JwtGenerator jwtGenerator;


    @SneakyThrows
    @Override
    public OAuthToken login(String code, UserInfo userInfo) {
        WxMaJscode2SessionResult sessionInfo = wxMaService.getUserService().getSessionInfo(code);
        String openid = sessionInfo.getOpenid();
        Result<UmsMember> result = memberFeignClient.getByOpenid(openid);
        UmsMember member;
        if (ResultCode.USER_NOT_EXIST.getCode().equals(result.getCode())) {
            // 用户不存在，注册成为新用户
            member = new UmsMember();
            BeanUtil.copyProperties(userInfo, member);
            member.setOpenid(openid);
            Result<Long> addRes = memberFeignClient.add(member);
            Assert.isTrue(ResultCode.SUCCESS.getCode().equals(addRes.getCode()), "微信用户注册失败");
            member.setId(addRes.getData()); // 新增后有了会员ID
        } else {
            member = result.getData();
        }

        // 自定义JWT生成
        // 1. JWT授权，一般存放用户的角色标识，用于资源服务器（网关）鉴权
        Set<String> authorities = new HashSet<>();
        // 2. JWT增强，携带用户ID等信息
        Map<String, String> additional = new HashMap<>();
        additional.put(AuthConstants.USER_ID_KEY, Convert.toStr(member.getId()));
        String accessToken = jwtGenerator.createAccessToken(authorities, additional);

        OAuthToken token = new OAuthToken().accessToken(accessToken);
        return token;
    }
}
