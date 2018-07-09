package com.laonog.admin.auth.biz.service.sysuser;

import com.laonog.admin.auth.dal.query.sysuser.SysUserQuery;
import com.laonog.admin.common.response.TableResultResponse;
import com.laonog.admin.auth.biz.vos.sysuser.SysUserVO;
import java.util.List;

/**
 * 
 *
 * @author sunchenguang
 * @email scg16@126.com
 * @date 2018-07-09 18:45:59
 */
public interface SysUserService {

    /**
     * 新增
     * @param sysUserVO
     * @return
     */
    public Boolean insertSysUser(SysUserVO sysUserVO);

    /**
     * 删除
     * @param sysUserVO
     * @return
     */
    public Boolean deleteSysUser(SysUserVO sysUserVO);

    /**
     * 修改
     * @param sysUserVO
     * @return
     */
    Boolean updateSysUser(SysUserVO sysUserVO);

    /**
     * 查询单个
     * @param sysUserQuery
     * @return
     */
    public SysUserVO getSysUser(SysUserQuery sysUserQuery);

    /**
     * 查询列表
     * @param sysUserQuery
     * @return
     */
    public List<SysUserVO> getSysUserList(SysUserQuery sysUserQuery);

    /**
     * 查询分页
     * @param sysUserQuery
     * @return
     */
    public TableResultResponse<SysUserVO> getSysUserPage(SysUserQuery sysUserQuery);
}