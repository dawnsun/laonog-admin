package com.laonog.admin.auth.biz.service.impl.sysuser;

import com.laonog.admin.auth.biz.service.sysuser.SysUserService;
import com.laonog.admin.auth.common.enums.ErrorCodeEnum;
import com.laonog.admin.auth.common.enums.SuccessCodeEnum;
import com.laonog.admin.auth.dal.query.sysuser.SysUserQuery;
import com.laonog.admin.common.response.TableResultResponse;
import com.laonog.auth.api.vos.sysuser.SysUserVO;
import org.springframework.stereotype.Service;
import com.laonog.admin.auth.dal.entity.sysuser.SysUserDO;
import com.laonog.admin.auth.dal.dao.sysuser.SysUserDAO;
import com.laonog.admin.auth.biz.converter.sysuser.SysUserConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

/**
 * 
 *
 * @author sunchenguang
 * @email scg16@126.com
 * @date 2018-07-09 18:45:59
 */
@Service
public class SysUserServiceImpl implements SysUserService {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Resource
    private SysUserDAO sysUserDAO;

    /**
     * 新增
     * @param sysUserVO
     * @return
     */
    @Override
    public Boolean insertSysUser(SysUserVO sysUserVO){
        try{
            SysUserDO sysUserDO = SysUserConverter.convertVO2DO(sysUserVO);
            Integer id = sysUserDAO.insertSysUser(sysUserDO);
            if(id>0){
                return true;
            }else{
                return false;
            }
        } catch (Exception e) {
            logger.error("SysUserService insertSysUser " + e);
            return false;
        }
    }

    /**
     * 删除
     * @param sysUserVO
     * @return
     */
    @Override
    public Boolean deleteSysUser(SysUserVO sysUserVO){
        try{
            SysUserDO sysUserDO = SysUserConverter.convertVO2DO(sysUserVO);
            Integer id = sysUserDAO.deleteSysUser(sysUserDO);
            if(id>0){
                return true;
            }else{
                return false;
            }
        } catch (Exception e) {
            logger.error("SysUserService deleteSysUser " + e);
            return false;
        }
    }

    /**
     * 修改
     * @param sysUserVO
     * @return
     */
    @Override
    public Boolean updateSysUser(SysUserVO sysUserVO){
        try{
            SysUserDO sysUserDO = SysUserConverter.convertVO2DO(sysUserVO);
            Integer id = sysUserDAO.updateSysUser(sysUserDO);
            if(id>0){
                    sysUserVO = SysUserConverter.convertDO2VO(sysUserDO);
                return true;
            }else{
                    sysUserVO = null;
                return false;
            }
        } catch (Exception e) {
            logger.error("SysUserService updateSysUser " + e);
                sysUserVO = null;
            return false;
        }
    }

    /**
     * 查询单个
     * @param sysUserQuery
     * @return
     */
    @Override
    public SysUserVO getSysUser(SysUserQuery sysUserQuery){
        try{
            SysUserDO sysUserDO = sysUserDAO.getSysUser(sysUserQuery);
            return SysUserConverter.convertDO2VO(sysUserDO);
        } catch (Exception e) {
            logger.error("SysUserService getSysUser " + e);
            return null;
        }
    }

    /**
     * 查询列表
     * @param sysUserQuery
     * @return
     */
    @Override
    public List<SysUserVO> getSysUserList(SysUserQuery sysUserQuery){
        try{
            List<SysUserDO> sysUserDOList = sysUserDAO.getSysUserList(sysUserQuery);
            return SysUserConverter.convertDOs2VOs(sysUserDOList);
        } catch (Exception e) {
            logger.error("SysUserService getSysUserList " + e);
            return null;
        }
    }

    /**
     * 查询分页
     * @param sysUserQuery
     * @return
     */
    @Override
    public TableResultResponse<SysUserVO> getSysUserPage(SysUserQuery sysUserQuery){
        try{
            List<SysUserVO> sysUserVOList = new ArrayList<>();
            Long count = sysUserDAO.getSysUserCount(sysUserQuery);
            List<SysUserDO> sysUserDOList = sysUserDAO.getSysUserPage(sysUserQuery);
            sysUserVOList = SysUserConverter.convertDOs2VOs(sysUserDOList);
            return new TableResultResponse<>(SuccessCodeEnum.QUERY_PAGE_SUCCESS.getSuccessMessage(),sysUserQuery.getPageNo(), sysUserQuery.getPageSize(), count, sysUserVOList);
        } catch (Exception e) {
            logger.error("SysUserService getSysUserPage " + e);
            return new TableResultResponse<>(ErrorCodeEnum.QUERY_PAGE_ERROR.getErrorCode(),ErrorCodeEnum.QUERY_PAGE_ERROR.getErrorMessage());
        }
    }
}