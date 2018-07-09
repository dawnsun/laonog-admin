package com.laonog.admin.common.exceprion;

import com.laonog.admin.common.constant.RestCodeConstants;

public class ClientForbiddenException extends BaseException {
    public ClientForbiddenException(String message) {
        super(message, RestCodeConstants.EX_CLIENT_FORBIDDEN_CODE);
    }

}
