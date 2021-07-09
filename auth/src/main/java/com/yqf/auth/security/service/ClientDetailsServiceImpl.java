package com.yqf.auth.security.service;
import com.yqf.admin.api.OAuthClientFeignClient;
import com.yqf.admin.pojo.entity.SysOauthClient;
import com.yqf.auth.common.enums.PasswordEncoderTypeEnum;
import com.yqf.common.result.Result;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.NoSuchClientException;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class ClientDetailsServiceImpl implements ClientDetailsService {

    @Resource
    private OAuthClientFeignClient oAuthClientFeignClient;

    @Override
    @SneakyThrows
    public ClientDetails loadClientByClientId(String clientId) {
        try {
            Result<SysOauthClient> result = oAuthClientFeignClient.getOAuthClientById(clientId);
            if (Result.success().getCode().equals(result.getCode())) {
                SysOauthClient client = result.getData();
                BaseClientDetails clientDetails = new BaseClientDetails(
                        client.getClientId(),
                        client.getResourceIds(),
                        client.getScope(),
                        client.getAuthorizedGrantTypes(),
                        client.getAuthorities(),
                        client.getWebServerRedirectUri());
                clientDetails.setClientSecret(PasswordEncoderTypeEnum.NOOP.getPrefix() + client.getClientSecret());
                return clientDetails;
            } else {
                throw new NoSuchClientException("No client with requested id: " + clientId);
            }
        } catch (EmptyResultDataAccessException var4) {
            throw new NoSuchClientException("No client with requested id: " + clientId);
        }
    }
}
