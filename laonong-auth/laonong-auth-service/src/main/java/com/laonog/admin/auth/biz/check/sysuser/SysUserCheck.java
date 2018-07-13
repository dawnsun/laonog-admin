package com.laonog.admin.auth.biz.check.sysuser;

import com.laonog.admin.auth.common.enums.ErrorCodeEnum;
import com.laonog.admin.auth.common.enums.SuccessCodeEnum;
import com.laonog.admin.common.response.CheckResponse;
import com.laonog.auth.api.vos.sysuser.SysUserVO;
import org.springframework.util.StringUtils;

/**
 *
 */
public class SysUserCheck {
    /**
     * 入参数据校验
     * @param sysUserVO
     * @return
     */
    public static CheckResponse checkInsertPaream(SysUserVO sysUserVO){
        if(null==sysUserVO){
            return new CheckResponse(ErrorCodeEnum.PARAM_IS_EMPTY.getErrorCode(), ErrorCodeEnum.PARAM_IS_EMPTY.getErrorMessage());
        }
        if(StringUtils.isEmpty(sysUserVO.getUsername())){
            return new CheckResponse(ErrorCodeEnum.PARAM_IS_EMPTY.getErrorCode(), ErrorCodeEnum.PARAM_IS_EMPTY.getErrorMessage());
        }
        if(StringUtils.isEmpty(sysUserVO.getUsername())){
            return new CheckResponse(ErrorCodeEnum.PARAM_IS_EMPTY.getErrorCode(), ErrorCodeEnum.PARAM_IS_EMPTY.getErrorMessage());
        }
        if(StringUtils.isEmpty(sysUserVO.getUsername())){
            return new CheckResponse(ErrorCodeEnum.PARAM_IS_EMPTY.getErrorCode(), ErrorCodeEnum.PARAM_IS_EMPTY.getErrorMessage());
        }
        if(StringUtils.isEmpty(sysUserVO.getUsername())){
            return new CheckResponse(ErrorCodeEnum.PARAM_IS_EMPTY.getErrorCode(), ErrorCodeEnum.PARAM_IS_EMPTY.getErrorMessage());
        }
        if(StringUtils.isEmpty(sysUserVO.getUsername())){
            return new CheckResponse(ErrorCodeEnum.PARAM_IS_EMPTY.getErrorCode(), ErrorCodeEnum.PARAM_IS_EMPTY.getErrorMessage());
        }
        if(StringUtils.isEmpty(sysUserVO.getUsername())){
            return new CheckResponse(ErrorCodeEnum.PARAM_IS_EMPTY.getErrorCode(), ErrorCodeEnum.PARAM_IS_EMPTY.getErrorMessage());
        }
        return new CheckResponse(SuccessCodeEnum.PAREAM_CHEKC.getSuccessMessage());
    }
}
