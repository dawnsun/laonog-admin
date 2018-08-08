/*
package com.laonog.admin.auth.biz.controller.sysuser;

import com.laonog.admin.auth.biz.check.sysuser.SysUserCheck;
import com.laonog.admin.auth.biz.service.sysuser.SysUserService;
import com.laonog.admin.auth.common.enums.ErrorCodeEnum;
import com.laonog.admin.auth.common.enums.SuccessCodeEnum;
import com.laonog.admin.common.constant.DataStateConstants;
import com.laonog.admin.common.response.CheckResponse;
import com.laonog.admin.common.response.ObjectRestResponse;
import com.laonog.auth.api.facade.sysuser.LoginClient;
import com.laonog.auth.api.vos.sysuser.SysUserVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.common.exceptions.InvalidGrantException;
import org.springframework.security.oauth2.provider.endpoint.TokenEndpoint;
import org.springframework.security.oauth2.provider.token.ConsumerTokenServices;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
@RestController
public class LoginController implements LoginClient {
    private static final Logger logger = LoggerFactory.getLogger(LoginClient.class);

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private TokenEndpoint tokenEndpoint;

    @Autowired
    @Qualifier("consumerTokenServices")
    private ConsumerTokenServices consumerTokenServices;

    @Override
    public ObjectRestResponse<OAuth2AccessToken> login(@RequestParam Map<String, String> parameters) {
        try {
            logger.info("login  start ......");
            parameters.put("grant_type","password");//设置授权类型为密码模式
            Collection<GrantedAuthority> grantedAuthorities = new HashSet<>();
            grantedAuthorities.add(new SimpleGrantedAuthority("admin"));//此处不能为空
            Authentication authentication = new UsernamePasswordAuthenticationToken("webapp", "webapp",grantedAuthorities);
            ResponseEntity<OAuth2AccessToken> responseEntity= tokenEndpoint.postAccessToken(authentication ,parameters);
            logger.info("login  end ......");
            return new ObjectRestResponse<>(SuccessCodeEnum.LOGIN_SUCCESS.getSuccessMessage(),responseEntity.getBody());
        }catch (InvalidGrantException e){
            logger.error("login error  用户名密码不正确 ....",e);
            return new ObjectRestResponse<>(ErrorCodeEnum.LOGIN_ERROR.getErrorCode(),ErrorCodeEnum.LOGIN_ERROR.getErrorMessage());
        }
        catch (Exception e){
            logger.error("login error ....",e);
            return new ObjectRestResponse<>(ErrorCodeEnum.SYSTEM_ERROR.getErrorCode(),ErrorCodeEnum.SYSTEM_ERROR.getErrorMessage());
        }
    }

    @Override
    public ObjectRestResponse<Boolean> logouting(@PathVariable("accessToken") String accessToken) {
        try {
            logger.info("logout  start ......");
            Boolean result = false;
            result = consumerTokenServices.revokeToken(accessToken);
            logger.info("logout  end ......");
            return new ObjectRestResponse<>(SuccessCodeEnum.LOGIN_SUCCESS.getSuccessMessage(),result);
        }
        catch (Exception e){
            logger.error("logout error ....",e);
            return new ObjectRestResponse<>(ErrorCodeEnum.SYSTEM_ERROR.getErrorCode(),ErrorCodeEnum.SYSTEM_ERROR.getErrorMessage());
        }
    }

    @Override
    public ObjectRestResponse<SysUserVO> registry(@RequestBody SysUserVO sysUserVO) {
        CheckResponse checkResponse = SysUserCheck.checkInsertPaream(sysUserVO);
        if(checkResponse.isRel()){
            return new ObjectRestResponse<>(checkResponse.getErrorCode(),checkResponse.getMsg());
        }
        sysUserVO.setUserStatus(DataStateConstants.USERSTATUS_LOCK);
        boolean result = sysUserService.insertSysUser(sysUserVO);
        if(result){
            return new ObjectRestResponse<>(SuccessCodeEnum.INSERT_SUCCESS.getSuccessMessage(),sysUserVO);
        }else{
            return new ObjectRestResponse<>(ErrorCodeEnum.INSERT_ERROR.getErrorCode(),ErrorCodeEnum.INSERT_ERROR.getErrorMessage(),sysUserVO);
        }
    }

}
*/
