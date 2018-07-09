package com.laonog.admin.common.exceprion;

import com.laonog.admin.common.constant.RestCodeConstants;

public class UserTokenException extends BaseException {
    public UserTokenException(String message) {
        super(message, RestCodeConstants.TOKEN_ERROR_CODE);
    }
}
