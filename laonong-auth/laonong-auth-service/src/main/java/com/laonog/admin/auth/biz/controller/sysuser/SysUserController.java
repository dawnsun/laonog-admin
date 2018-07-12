package com.laonog.admin.auth.biz.controller.sysuser;

import com.laonog.admin.auth.biz.check.sysuser.SysUserCheck;
import com.laonog.admin.auth.biz.service.sysuser.SysUserService;
import com.laonog.admin.auth.dal.query.sysuser.SysUserQuery;
import com.laonog.admin.common.response.CheckResponse;
import com.laonog.admin.common.response.ListRestResponse;
import com.laonog.admin.common.response.ObjectRestResponse;
import com.laonog.admin.common.response.TableResultResponse;
import com.laonog.auth.api.facade.sysuser.SysUserClient;
import com.laonog.auth.api.facade.sysuser.com.laonog.auth.api.vos.sysuser.SysUserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SysUserController implements SysUserClient {

    @Autowired
    private SysUserService sysUserService;

    @Override
    public ObjectRestResponse<SysUserVO> insertSysUser(SysUserVO sysUserVO) {
        CheckResponse checkResponse = SysUserCheck.checkInsertPaream(sysUserVO);
        if(checkResponse.isRel()){
            return new ObjectRestResponse<SysUserVO>(checkResponse.getErrorCode(),checkResponse.getMsg());
        }
        boolean result = sysUserService.insertSysUser(sysUserVO);
        return new ObjectRestResponse<SysUserVO>("insertSysUser success",sysUserVO);
    }

    @Override
    public ObjectRestResponse<Boolean> deleteSysUser(Long id) {
        return null;
    }

    @Override
    public ObjectRestResponse<SysUserVO> updateSysUser(SysUserVO sysUserVO) {
        return null;
    }

    @Override
    public ObjectRestResponse<SysUserVO> getSysUser(Long id) {
        return null;
    }

    @Override
    public ListRestResponse<List<SysUserVO>> getSysUserList(SysUserQuery sysUserQuery) {
        return null;
    }

    @Override
    public TableResultResponse<SysUserVO> getSysUserPage(SysUserQuery sysUserQuery) {
        return null;
    }

}
