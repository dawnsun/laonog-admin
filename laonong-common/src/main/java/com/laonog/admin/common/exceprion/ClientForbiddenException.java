package com.laonog.admin.common.exceprion;

import com.laonog.admin.common.constant.RestCodeConstants;

/**
 * 客户端禁用异常
 */
public class ClientForbiddenException extends BaseException {
    public ClientForbiddenException(String message) {
        super(message, RestCodeConstants.EX_CLIENT_FORBIDDEN_CODE);
    }

}
