/*
package com.laonog.admin.auth.config;

import com.laonog.admin.auth.biz.service.impl.security.SecurityClientDetailsServiceImpl;
import com.laonog.admin.auth.biz.service.impl.security.SecurityUserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;


*/
/**
 * 认证服务器，进行认证和授权
 *//*

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private RedisConnectionFactory connectionFactory;

    @Bean
    public UserDetailsService userDetailsService(){
        return new SecurityUserDetailsServiceImpl();
    }

    @Bean
    public ClientDetailsService clientDetailsService(){
        return new SecurityClientDetailsServiceImpl();
    }

    @Bean
    public RedisTokenStore tokenStore() {
        return new RedisTokenStore(connectionFactory);
    }

    */
/**
     * 配置授权类型 用来配置授权（authorization）以及令牌（token）的访问端点和令牌服务(token services)。
     * 也就是 token 存储方式、token 配置、用户授权模式等。默认不需做任何配置，除非使用 密码授权方式, 这时候必须配置 AuthenticationManager。
     * @param endpoints
     * @throws Exception
     *//*

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints
            .authenticationManager(authenticationManager)
            .userDetailsService(userDetailsService())//若无，refresh_token会有UserDetailsService is required错误
            //   .tokenStore(tokenStore());
            .tokenStore(new InMemoryTokenStore());
    }

    */
/**
     * 用来配置令牌端点(Token Endpoint)的安全约束.
     * 明安全约束，哪些允许访问，哪些不允许访问。配置
     * @param security
     * @throws Exception
     *//*

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security
            .tokenKeyAccess("permitAll()")
            .checkTokenAccess("permitAll()")
            .allowFormAuthenticationForClients();

    }

    */
/**
     * client客户端的信息配置 用来配置客户端详情服务（ClientDetailsService），客户端详情信息在这里进行初始化，你能够把客户端详情信息写死在这里或者是通过数据库来存储调取详情信息
     * 包括权限范围、授权方式、客户端权限等配置。授权方式有4种:implicit, client_redentials, password , authorization_code, 其中密码授权方式必须结合
     * @param clients
     * @throws Exception
     *//*

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.withClientDetails(clientDetailsService());
    }

}
*/
