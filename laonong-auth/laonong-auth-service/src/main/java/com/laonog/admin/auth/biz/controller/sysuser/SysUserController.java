package com.laonog.admin.auth.biz.controller.sysuser;

import com.ctc.wstx.util.StringUtil;
import com.laonog.admin.auth.biz.service.sysuser.SysUserService;
import com.laonog.admin.auth.common.constants.com.laonog.admin.auth.common.enums.ErrorCodeEnum;
import com.laonog.admin.auth.common.constants.com.laonog.admin.auth.common.enums.SuccessCodeEnum;
import com.laonog.admin.auth.dal.query.sysuser.SysUserQuery;
import com.laonog.admin.common.response.BaseResponse;
import com.laonog.admin.common.response.ListRestResponse;
import com.laonog.admin.common.response.ObjectRestResponse;
import com.laonog.admin.common.response.TableResultResponse;
import com.laonog.auth.api.facade.sysuser.SysUserClient;
import com.laonog.auth.api.facade.sysuser.com.laonog.auth.api.vos.sysuser.SysUserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SysUserController implements SysUserClient {

    @Autowired
    private SysUserService sysUserService;

    @Override
    public ObjectRestResponse<SysUserVO> insertSysUser(SysUserVO sysUserVO) {
        if(checkPaream(sysUserVO).isRel()){
            return new ObjectRestResponse<SysUserVO>("",null);
        }
        return null;
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

    public BaseResponse checkPaream(SysUserVO sysUserVO){
        if(null==sysUserVO){
            return new BaseResponse(false, ErrorCodeEnum.PARAM_IS_EMPTY.getErrorMessage());
        }
        if(StringUtils.isEmpty(sysUserVO.getUsername())){
            return new BaseResponse(false,"");
        }
        return new BaseResponse(SuccessCodeEnum.PAREAM_CHEKC.getSuccessMessage());
    }
}
