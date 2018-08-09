package com.laonog.weixin.util;

import com.laonog.weixin.WxErrorExceptionHandler;
import com.laonog.weixin.error.WxErrorException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogExceptionHandler implements WxErrorExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(LogExceptionHandler.class);

  @Override
  public void handle(WxErrorException e) {

    logger.error("Error happens", e);

  }

}
