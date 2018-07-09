package com.laonog.admin.common.exceprion;

import com.laonog.admin.common.constant.RestCodeConstants;

public class ClientTokenException extends BaseException {
    public ClientTokenException(String message) {
        super(message, RestCodeConstants.TOKEN_FORBIDDEN_CODE);
    }
}
