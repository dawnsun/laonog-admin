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

    @Override
    public ObjectRestResponse<Boolean> deleteSysUser(@PathVariable Long id) {
        CheckResponse checkResponse = SysUserCheck.checkPareamKey(id);
        if(checkResponse.isRel()){
            return new ObjectRestResponse<>(checkResponse.getErrorCode(),checkResponse.getMsg());
        }
        SysUserVO sysUserVO = new SysUserVO();
        sysUserVO.setId(id);
        boolean result = sysUserService.deleteSysUser(sysUserVO);
        if(result){
            return new ObjectRestResponse<>(SuccessCodeEnum.DELETE_SUCCESS.getSuccessMessage(),result);
        }else{
            return new ObjectRestResponse<>(ErrorCodeEnum.DELETE_ERROR.getErrorCode(),ErrorCodeEnum.DELETE_ERROR.getErrorMessage(),result);
        }
    }

    @Override
    public ObjectRestResponse<SysUserVO> updateSysUser(@RequestBody SysUserVO sysUserVO) {
        CheckResponse checkResponse = SysUserCheck.checkUpdatePaream(sysUserVO);
        if(checkResponse.isRel()){
            return new ObjectRestResponse<>(checkResponse.getErrorCode(),checkResponse.getMsg());
        }
        SysUserQuery sysUserQuery = new SysUserQuery();
        sysUserQuery.setId(sysUserVO.getId());
        sysUserQuery.setIsDelete(DataStateConstants.IS_DELETED);
        SysUserVO sysUserVOOld = sysUserService.getSysUser(sysUserQuery);
        if(null == sysUserVOOld){
            return new ObjectRestResponse<>(ErrorCodeEnum.UPDATE_ERROR.getErrorCode(),ErrorCodeEnum.UPDATE_ERROR.getErrorMessage(),sysUserVO);
        }
        sysUserVO.setUserStatus(DataStateConstants.USERSTATUS_LOCK);
        boolean result = sysUserService.updateSysUser(sysUserVO);
        if(result){
            return new ObjectRestResponse<>(SuccessCodeEnum.UPDATE_SUCCESS.getSuccessMessage(),sysUserVO);
        }else{
            return new ObjectRestResponse<>(ErrorCodeEnum.UPDATE_ERROR.getErrorCode(),ErrorCodeEnum.UPDATE_ERROR.getErrorMessage(),sysUserVO);
        }
    }

    @Override
    public ObjectRestResponse<SysUserVO> getSysUser(@PathVariable Long id) {
        CheckResponse checkResponse = SysUserCheck.checkPareamKey(id);
        if(checkResponse.isRel()){
            return new ObjectRestResponse<>(checkResponse.getErrorCode(),checkResponse.getMsg());
        }
        SysUserQuery sysUserQuery = new SysUserQuery();
        sysUserQuery.setId(id);
        sysUserQuery.setIsDelete(DataStateConstants.IS_DELETED);
        SysUserVO sysUserVO = sysUserService.getSysUser(sysUserQuery);
        if(null != sysUserVO){
            return new ObjectRestResponse<>(SuccessCodeEnum.QUERY_SUCCESS.getSuccessMessage(),sysUserVO);
        }else{
            return new ObjectRestResponse<>(ErrorCodeEnum.QUERY_ERROR.getErrorCode(),ErrorCodeEnum.QUERY_ERROR.getErrorMessage(),sysUserVO);
        }
    }

    @Override
    public ListRestResponse<SysUserVO> getSysUserList(@RequestBody SysUserQuery sysUserQuery){
        CheckResponse checkResponse = SysUserCheck.checkListPaream(sysUserQuery);
        if(checkResponse.isRel()){
            return new ListRestResponse<>(checkResponse.getErrorCode(),checkResponse.getMsg());
        }
        List<SysUserVO> sysUserVOList = sysUserService.getSysUserList(sysUserQuery);
        if(null != sysUserVOList && sysUserVOList.size()>0){
            return new ListRestResponse<>(SuccessCodeEnum.QUERY_SUCCESS.getSuccessMessage(),sysUserVOList);
        }else{
            return new ListRestResponse<>(ErrorCodeEnum.QUERY_ERROR.getErrorCode(),ErrorCodeEnum.QUERY_ERROR.getErrorMessage(),sysUserVOList);
        }
    }

    @Override
    public TableResultResponse<SysUserVO> getSysUserPage(@RequestBody SysUserQuery sysUserQuery) {
        CheckResponse checkResponse = SysUserCheck.checkPagePaream(sysUserQuery);
        if(checkResponse.isRel()){
            return new TableResultResponse<>(checkResponse.getErrorCode(),checkResponse.getMsg());
        }
        return sysUserService.getSysUserPage(sysUserQuery);
    }

}
