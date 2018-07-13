package com.laonog.admin.auth.biz.check.sysuser;

import com.laonog.admin.common.response.CheckResponse;
import com.laonog.auth.api.vos.sysuser.SysUserVO;
import org.apache.commons.lang.StringUtils;
import com.laonog.admin.auth.common.enums.ErrorCodeEnum;
import com.laonog.admin.auth.common.enums.SuccessCodeEnum;
import com.laonog.admin.auth.common.enums.sysuser.SysUserCodeEnum;

/**
 * @author sunchenguang
 * @email scg16@126.com
 * @date 2018-07-13 15:43:23
 */
public class SysUserCheck {

    /**
     * 新增入参数据校验
     *
     * @param sysUserVO
     * @return
     */
    public static CheckResponse checkInsertPaream(SysUserVO sysUserVO) {
        if (null == sysUserVO) {
            return new CheckResponse(ErrorCodeEnum.PARAM_IS_EMPTY.getErrorCode(),
                ErrorCodeEnum.PARAM_IS_EMPTY.getErrorMessage());
        }
        if (null == sysUserVO.getUsername()) {
            return new CheckResponse(
                SysUserCodeEnum.USERNAME_EMPTY.getCode(),
                SysUserCodeEnum.USERNAME_EMPTY
                    .getMessage());
        }
        if (null == sysUserVO.getPassword()) {
            return new CheckResponse(
                SysUserCodeEnum.PASSWORD_EMPTY.getCode(),
                SysUserCodeEnum.PASSWORD_EMPTY
                    .getMessage());
        }
        if (null == sysUserVO.getPhoneNumber()) {
            return new CheckResponse(
                SysUserCodeEnum.PHONE_NUMBER_EMPTY.getCode(),
                SysUserCodeEnum.PHONE_NUMBER_EMPTY
                    .getMessage());
        }

        return new CheckResponse(SuccessCodeEnum.PAREAM_CHEKC.getSuccessMessage());
    }

    /**
     * 修改入参数据校验
     *
     * @param sysUserVO
     * @return
     */
    public static CheckResponse checkUpdatePaream(SysUserVO sysUserVO) {
        if (null == sysUserVO) {
            return new CheckResponse(ErrorCodeEnum.PARAM_IS_EMPTY.getErrorCode(),
                ErrorCodeEnum.PARAM_IS_EMPTY.getErrorMessage());
        }
        if (null == sysUserVO.getId()) {
            return new CheckResponse(
                SysUserCodeEnum.ID_EMPTY.getCode(),
                SysUserCodeEnum.ID_EMPTY.getMessage());
        }
        if (null == sysUserVO.getUsername()) {
            return new CheckResponse(
                SysUserCodeEnum.USERNAME_EMPTY.getCode(),
                SysUserCodeEnum.USERNAME_EMPTY.getMessage());
        }
        if (null == sysUserVO.getPassword()) {
            return new CheckResponse(
                SysUserCodeEnum.PASSWORD_EMPTY.getCode(),
                SysUserCodeEnum.PASSWORD_EMPTY.getMessage());
        }
        if (null == sysUserVO.getPhoneNumber()) {
            return new CheckResponse(
                SysUserCodeEnum.PHONE_NUMBER_EMPTY.getCode(),
                SysUserCodeEnum.PHONE_NUMBER_EMPTY.getMessage());
        }

        return new CheckResponse(SuccessCodeEnum.PAREAM_CHEKC.getSuccessMessage());
    }

    /**
     * 单条数据主键数据校验
     *
     * @param id
     * @return
     */
    public static CheckResponse checkPareamKey(Long id) {
        if (null == id) {
            return new CheckResponse(ErrorCodeEnum.PARAM_IS_EMPTY.getErrorCode(),
                ErrorCodeEnum.PARAM_IS_EMPTY.getErrorMessage());
        }
        return new CheckResponse(SuccessCodeEnum.PAREAM_CHEKC.getSuccessMessage());
    }
}
