package com.laonog.admin.auth.biz.service.impl.security;

import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.stereotype.Service;

/**
 * String clientId, String resourceIds, String scopes, String grantTypes, String authorities, String redirectUris
 * clientId、secret、scope、authorizedGrantTypes、authorities
 * （1）scope：表示权限范围，可选项，用户授权页面时进行选择
 * （2）authorizedGrantTypes：有四种授权方式
 * Authorization Code：用验证获取code，再用code去获取token（用的最多的方式，也是最安全的方式）
 * Implicit: 隐式授权模式
 * Client Credentials (用來取得 App Access Token)
 * Resource Owner Password Credentials
 （3）authorities：授予client的权限
 */
@Service
public class SecurityClientDetailsServiceImpl implements ClientDetailsService {
    @Override
    public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
        //ClientDetailsDO clientDetailsDO = clientDetailsService.findByClientId(clientId);
        //String resourceIds = clientDetailsDO.getResourceIds();
        //String scopes = clientDetailsDO.getScope();
        //String grantTypes = clientDetailsDO.getAuthorizedGrantTypes();
        //String authorities = clientDetailsDO.getAuthorities();
        //String redirectUris = clientDetailsDO.getWebServerRedirectUri();
        //Integer refreshTokenValiditySeconds = clientDetailsDO.getRefreshTokenValiditySeconds();
        //Integer accessTokenValiditySeconds = clientDetailsDO.getAccessTokenValiditySeconds();
        //String clientSecret=clientDetailsDO.getClientSecret();
        String resourceIds = "test";
        String scopes = "test";
        String grantTypes = "test";
        String authorities = "test";
        String redirectUris = "test";
            Integer refreshTokenVa = 1;
        Integer accessTokenVal = 1;
        String clientSecret="123";
        Integer refreshTokenValiditySeconds = 1000;
        Integer accessTokenValiditySeconds = 2000;
            BaseClientDetails baseClientDetails = new BaseClientDetails(clientId,resourceIds,scopes,grantTypes,authorities,redirectUris);
        baseClientDetails.setRefreshTokenValiditySeconds(refreshTokenValiditySeconds);
        baseClientDetails.setAccessTokenValiditySeconds(accessTokenValiditySeconds);
        baseClientDetails.setClientSecret(clientSecret);
        baseClientDetails.setClientId("webapp");
        baseClientDetails.setClientSecret("webapp");
        return baseClientDetails;
    }
}
