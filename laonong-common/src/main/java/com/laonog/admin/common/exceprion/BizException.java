package com.laonog.admin.common.exceprion;

public class BizException extends BaseException {

    public BizException(String message, int status) {
        super(message, status);
    }

    public BizException(String code, String message) {
        super(code,message);
    }

}
