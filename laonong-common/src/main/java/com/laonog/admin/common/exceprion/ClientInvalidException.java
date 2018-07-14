package com.laonog.admin.common.exceprion;

import com.laonog.admin.common.constant.RestCodeConstants;

/**
 * 客户端无效异常
 */
public class ClientInvalidException extends BaseException {
    public ClientInvalidException(String message) {
        super(message, RestCodeConstants.TOKEN_FORBIDDEN_CODE);
    }
}
