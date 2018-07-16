package com.laonog.auth.api.facade.sysuser;

import com.laonog.admin.auth.dal.query.sysuser.SysUserQuery;
import com.laonog.admin.common.response.ListRestResponse;
import com.laonog.admin.common.response.ObjectRestResponse;
import com.laonog.admin.common.response.TableResultResponse;
import com.laonog.auth.api.vos.sysuser.SysUserVO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("sysUser")
public interface SysUserClient {
    /**
     * 新增
     * @param sysUserVO
     * @return
     */
    @RequestMapping(value = "",method = RequestMethod.POST)
    ObjectRestResponse<SysUserVO> insertSysUser(@RequestBody SysUserVO sysUserVO);

    /**
     * 删除
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    ObjectRestResponse<Boolean> deleteSysUser(@PathVariable("id") Long id);

    /**
     * 修改
     * @param sysUserVO
     * @return
     */
    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    ObjectRestResponse<SysUserVO> updateSysUser(@RequestBody SysUserVO sysUserVO);

    /**
     * 查询单个
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    ObjectRestResponse<SysUserVO> getSysUser(@PathVariable("id") Long id);

    /**
     * 查询列表
     * @param sysUserQuery
     * @return
     */
    @RequestMapping(value = "/list",method = RequestMethod.POST)
    ListRestResponse<SysUserVO> getSysUserList(@RequestBody SysUserQuery sysUserQuery);

    /**
     * 查询分页
     * @param sysUserQuery
     * @return
     */
    @RequestMapping(value = "/page",method = RequestMethod.POST)
    TableResultResponse<SysUserVO> getSysUserPage(@RequestBody SysUserQuery sysUserQuery);
}
