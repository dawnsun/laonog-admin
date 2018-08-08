/*
package com.laonog.auth.api.facade.sysuser;

import com.laonog.admin.common.response.ObjectRestResponse;
import com.laonog.auth.api.vos.sysuser.SysUserVO;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

public interface LoginClient {

    @RequestMapping(value = "/sys/login",method = RequestMethod.POST)
    ObjectRestResponse<OAuth2AccessToken> login(@RequestParam Map<String, String> parameters);

    @RequestMapping(value = "/sys/logouting",method = RequestMethod.GET)
    ObjectRestResponse<Boolean> logouting(@PathVariable("accessToken") String accessToken);

    @RequestMapping(value = "/sys/registry",method = RequestMethod.POST)
    ObjectRestResponse<SysUserVO> registry(@RequestBody SysUserVO sysUserVO);
}
*/
