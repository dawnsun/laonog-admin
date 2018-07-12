package com.laonog.admin.auth.common.constants.com.laonog.admin.auth.common.enums;

import org.apache.commons.lang.StringUtils;

public enum SysUserCodeEnum {
    USERNAME_EMPTY("username empty", "用户名为空"),

    PASSWORD_EMPTY("password empty", "密码为空"),



    ;

    private String code;

    private String message;
    SysUserCodeEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * 根据code获取message
     *
     * @param code
     * @return
     */
    public static String getDescByCode(String code) {
        if (StringUtils.isBlank(code)) {
            return null;
        }
        for (SysUserCodeEnum object : SysUserCodeEnum.values()) {
            if (object.getCode().equals(code)) {
                return object.getMessage();
            }
        }
        return null;
    }

    /**
     * 根据code获取枚举对象
     *
     * @param code
     * @return
     */
    public static SysUserCodeEnum getEnumObjByCode(String code) {
        if (StringUtils.isBlank(code)) {
            return null;
        }
        for (SysUserCodeEnum object : SysUserCodeEnum.values()) {
            if (object.getCode().equals(code)) {
                return object;
            }
        }
        return null;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
