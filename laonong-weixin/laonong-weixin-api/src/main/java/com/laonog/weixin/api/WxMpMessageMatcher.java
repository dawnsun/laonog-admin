package com.laonog.weixin.api;

import com.laonog.weixin.bean.message.WxMpXmlMessage;

/**
 * 消息匹配器，用在消息路由的时候
 */
public interface WxMpMessageMatcher {

  /**
   * 消息是否匹配某种模式
   *
   * @param message
   */
  boolean match(WxMpXmlMessage message);

}
