package com.laonog.weixin;

import com.laonog.weixin.error.WxErrorException;

/**
 * WxErrorException处理器.
 */
public interface WxErrorExceptionHandler {

  void handle(WxErrorException e);

}
