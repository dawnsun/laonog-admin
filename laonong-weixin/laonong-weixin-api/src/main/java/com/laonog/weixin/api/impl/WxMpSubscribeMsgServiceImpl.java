package com.laonog.weixin.api.impl;

import com.laonog.weixin.api.WxMpConfigStorage;
import com.laonog.weixin.api.WxMpService;
import com.laonog.weixin.api.WxMpSubscribeMsgService;
import com.laonog.weixin.bean.subscribe.WxMpSubscribeMessage;
import com.laonog.weixin.error.WxErrorException;
import com.laonog.weixin.util.http.URIUtil;

/**
 * @author Mklaus
 * @date 2018-01-22 上午11:19
 */
public class WxMpSubscribeMsgServiceImpl implements WxMpSubscribeMsgService {
  private static final String SUBSCRIBE_MESSAGE_AUTHORIZE_URL =
    "https://mp.weixin.qq.com/mp/subscribemsg?action=get_confirm&appid=%s&scene=%d&template_id=%s&redirect_url=%s&reserved=%s#wechat_redirect";
  private static final String SEND_MESSAGE_URL = "https://api.weixin.qq.com/cgi-bin/message/template/subscribe";


  private WxMpService wxMpService;

  public WxMpSubscribeMsgServiceImpl(WxMpService wxMpService) {
    this.wxMpService = wxMpService;
  }

  @Override
  public String subscribeMsgAuthorizationUrl(String redirectURI, int scene, String reserved) {
    WxMpConfigStorage storage = this.wxMpService.getWxMpConfigStorage();
    return String.format(SUBSCRIBE_MESSAGE_AUTHORIZE_URL,
      storage.getAppId(), scene, storage.getTemplateId(), URIUtil.encodeURIComponent(redirectURI), reserved);
  }

  @Override
  public boolean sendSubscribeMessage(WxMpSubscribeMessage message) throws WxErrorException {
    if (message.getTemplateId() == null) {
      message.setTemplateId(this.wxMpService.getWxMpConfigStorage().getTemplateId());
    }

    String responseContent = this.wxMpService.post(SEND_MESSAGE_URL, message.toJson());
    return responseContent != null;
  }
}
