package com.laonog.admin.auth.dal.dao.sysuser;

import com.laonog.admin.auth.dal.entity.sysuser.SysUserDO;
import com.laonog.admin.auth.dal.query.sysuser.SysUserQuery;

import java.util.List;

/**
 * 
 * 
 * @author sunchenguang
 * @email scg16@126.com
 * @date 2018-07-09 18:45:59
 */
public interface SysUserDAO {

    /**
     * 新增
     * @param sysUserDO
     * @return
     */
    Integer insertSysUser(SysUserDO sysUserDO);

    /**
     * 删除
     * @param sysUserDO
     * @return
     */
    Integer deleteSysUser(SysUserDO sysUserDO);

    /**
     * 修改
     * @param sysUserDO
     * @return
     */
    Integer updateSysUser(SysUserDO sysUserDO);

    /**
     * 查询单个
     * @param sysUserQuery
     * @return
     */
    SysUserDO getSysUser(SysUserQuery sysUserQuery);

    /**
     * 查询数量
     * @param sysUserQuery
     * @return
     */
    Long getSysUserCount(SysUserQuery sysUserQuery);

    /**
     * 查询列表
     * @param sysUserQuery
     * @return
     */
    List<SysUserDO> getSysUserList(SysUserQuery sysUserQuery);

    /**
     * 查询分页
     * @param sysUserQuery
     * @return
     */
    List<SysUserDO> getSysUserPage(SysUserQuery sysUserQuery);
}