package com.laonog.admin.auth.biz.converter.sysuser;

import com.laonog.admin.auth.biz.vos.sysuser.SysUserVO;
import com.laonog.admin.auth.dal.entity.sysuser.SysUserDO;

import java.util.ArrayList;
import java.util.List;

/**
 * 数据模型转换
 *
 * @author sunchenguang
 * @email scg16@126.com
 * @date 2018-07-09 18:45:59
 */
public class SysUserConverter {

    public static SysUserDO convertVO2DO(SysUserVO sysUserVO){
        if(null == sysUserVO){
            return null;
        }
        SysUserDO sysUserDO = new SysUserDO();
                        sysUserDO.setId(sysUserVO.getId());
                        sysUserDO.setUsername(sysUserVO.getUsername());
                        sysUserDO.setPassword(sysUserVO.getPassword());
                        sysUserDO.setPhoneNumber(sysUserVO.getPhoneNumber());
                        sysUserDO.setAddress(sysUserVO.getAddress());
                        sysUserDO.setAvatar(sysUserVO.getAvatar());
                        sysUserDO.setNickname(sysUserVO.getNickname());
                        sysUserDO.setQrCode(sysUserVO.getQrCode());
                        sysUserDO.setSex(sysUserVO.getSex());
                        sysUserDO.setBirthday(sysUserVO.getBirthday());
                        sysUserDO.setUserStatus(sysUserVO.getUserStatus());
                        sysUserDO.setGmtCreate(sysUserVO.getGmtCreate());
                        sysUserDO.setGmtModified(sysUserVO.getGmtModified());
                        sysUserDO.setCreator(sysUserVO.getCreator());
                        sysUserDO.setModifier(sysUserVO.getModifier());
                        sysUserDO.setIsDelete(sysUserVO.getIsDelete());
                return sysUserDO;
    }

    public static SysUserVO convertDO2VO(SysUserDO sysUserDO){
        if(null == sysUserDO){
            return null;
        }
            SysUserVO sysUserVO = new SysUserVO();
                        sysUserVO.setId(sysUserDO.getId());
                        sysUserVO.setUsername(sysUserDO.getUsername());
                        sysUserVO.setPassword(sysUserDO.getPassword());
                        sysUserVO.setPhoneNumber(sysUserDO.getPhoneNumber());
                        sysUserVO.setAddress(sysUserDO.getAddress());
                        sysUserVO.setAvatar(sysUserDO.getAvatar());
                        sysUserVO.setNickname(sysUserDO.getNickname());
                        sysUserVO.setQrCode(sysUserDO.getQrCode());
                        sysUserVO.setSex(sysUserDO.getSex());
                        sysUserVO.setBirthday(sysUserDO.getBirthday());
                        sysUserVO.setUserStatus(sysUserDO.getUserStatus());
                        sysUserVO.setGmtCreate(sysUserDO.getGmtCreate());
                        sysUserVO.setGmtModified(sysUserDO.getGmtModified());
                        sysUserVO.setCreator(sysUserDO.getCreator());
                        sysUserVO.setModifier(sysUserDO.getModifier());
                        sysUserVO.setIsDelete(sysUserDO.getIsDelete());
                return sysUserVO;
    }

    public static List<SysUserVO> convertDOs2VOs(List<SysUserDO> sysUserDOList){
        if (null == sysUserDOList){
            return null;
        }
        List<SysUserVO> sysUserVOList = new ArrayList<>();
        for (SysUserDO sysUserDO : sysUserDOList){
                sysUserVOList.add(convertDO2VO(sysUserDO));
        }
        return sysUserVOList;
    }

}
