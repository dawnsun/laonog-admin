package com.laonog.admin.auth.biz.controller.sysuser;

import com.laonog.admin.auth.biz.check.sysuser.SysUserCheck;
import com.laonog.admin.auth.biz.service.sysuser.SysUserService;
import com.laonog.admin.auth.common.enums.ErrorCodeEnum;
import com.laonog.admin.auth.common.enums.SuccessCodeEnum;
import com.laonog.admin.auth.dal.query.sysuser.SysUserQuery;
import com.laonog.admin.common.constant.DataStateConstants;
import com.laonog.admin.common.response.CheckResponse;
import com.laonog.admin.common.response.ListRestResponse;
import com.laonog.admin.common.response.ObjectRestResponse;
import com.laonog.admin.common.response.TableResultResponse;
import com.laonog.auth.api.facade.sysuser.SysUserClient;
import com.laonog.auth.api.vos.sysuser.SysUserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SysUserController implements SysUserClient {

    @Autowired
    private SysUserService sysUserService;

    @Override
    public ObjectRestResponse<SysUserVO> insertSysUser(@RequestBody SysUserVO sysUserVO) {
        CheckResponse checkResponse = SysUserCheck.checkInsertPaream(sysUserVO);
        if(checkResponse.isRel()){
            return new ObjectRestResponse<SysUserVO>(checkResponse.getErrorCode(),checkResponse.getMsg());
        }
        sysUserVO.setCreator("creator");
        sysUserVO.setModifier("modifier");
        sysUserVO.setUserStatus(DataStateConstants.USERSTATUS_LOCK);
        sysUserVO.setIsDelete(DataStateConstants.IS_DELETED);
        boolean result = sysUserService.insertSysUser(sysUserVO);
        if(result){
            return new ObjectRestResponse<SysUserVO>(SuccessCodeEnum.INSERT_SUCCESS.getSuccessMessage(),sysUserVO);
        }else{
            return new ObjectRestResponse<SysUserVO>(ErrorCodeEnum.INSERT_ERROR.getErrorCode(),ErrorCodeEnum.INSERT_ERROR.getErrorMessage(),sysUserVO);
        }

    }

    @Override
    public ObjectRestResponse<Boolean> deleteSysUser(@PathVariable Long id) {
        CheckResponse checkResponse = SysUserCheck.checkPareamKey(id);
        if(checkResponse.isRel()){
            return new ObjectRestResponse<Boolean>(checkResponse.getErrorCode(),checkResponse.getMsg());
        }
        SysUserVO sysUserVO = new SysUserVO();
        sysUserVO.setId(id);
        sysUserVO.setIsDelete(DataStateConstants.DELETED);
        boolean result = sysUserService.deleteSysUser(sysUserVO);
        if(result){
            return new ObjectRestResponse<Boolean>(SuccessCodeEnum.DELETE_SUCCESS.getSuccessMessage(),result);
        }else{
            return new ObjectRestResponse<Boolean>(ErrorCodeEnum.DELETE_ERROR.getErrorCode(),ErrorCodeEnum.DELETE_ERROR.getErrorMessage(),result);
        }
    }

    @Override
    public ObjectRestResponse<SysUserVO> updateSysUser(@RequestBody SysUserVO sysUserVO) {
        CheckResponse checkResponse = SysUserCheck.checkUpdatePaream(sysUserVO);
        if(checkResponse.isRel()){
            return new ObjectRestResponse<SysUserVO>(checkResponse.getErrorCode(),checkResponse.getMsg());
        }
        sysUserVO.setCreator("creator");
        sysUserVO.setModifier("modifier");
        sysUserVO.setUserStatus(DataStateConstants.USERSTATUS_LOCK);
        sysUserVO.setIsDelete(DataStateConstants.IS_DELETED);
        boolean result = sysUserService.updateSysUser(sysUserVO);
        if(result){
            return new ObjectRestResponse<SysUserVO>(SuccessCodeEnum.UPDATE_SUCCESS.getSuccessMessage(),sysUserVO);
        }else{
            return new ObjectRestResponse<SysUserVO>(ErrorCodeEnum.UPDATE_ERROR.getErrorCode(),ErrorCodeEnum.UPDATE_ERROR.getErrorMessage(),sysUserVO);
        }
    }

    @Override
    public ObjectRestResponse<SysUserVO> getSysUser(@PathVariable Long id) {
        CheckResponse checkResponse = SysUserCheck.checkPareamKey(id);
        if(checkResponse.isRel()){
            return new ObjectRestResponse<SysUserVO>(checkResponse.getErrorCode(),checkResponse.getMsg());
        }
        SysUserQuery sysUserQuery = new SysUserQuery();
        sysUserQuery.setId(id);
        sysUserQuery.setIsDelete(DataStateConstants.IS_DELETED);
        SysUserVO sysUserVO = sysUserService.getSysUser(sysUserQuery);
        if(null != sysUserVO){
            return new ObjectRestResponse<SysUserVO>(SuccessCodeEnum.QUERY_SUCCESS.getSuccessMessage(),sysUserVO);
        }else{
            return new ObjectRestResponse<SysUserVO>(ErrorCodeEnum.QUERY_ERROR.getErrorCode(),ErrorCodeEnum.QUERY_ERROR.getErrorMessage(),sysUserVO);
        }
    }

    @Override
    public ListRestResponse<List<SysUserVO>> getSysUserList(@RequestBody SysUserQuery sysUserQuery) {
        return null;
    }

    @Override
    public TableResultResponse<SysUserVO> getSysUserPage(@RequestBody SysUserQuery sysUserQuery) {
        return null;
    }

}
