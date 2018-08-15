package com.laonog.weixin.api.impl;

import com.google.gson.JsonObject;
import com.laonog.weixin.api.WxMpMassMessageService;
import com.laonog.weixin.api.WxMpService;
import com.laonog.weixin.bean.*;
import com.laonog.weixin.bean.result.WxMpMassSendResult;
import com.laonog.weixin.bean.result.WxMpMassUploadResult;
import com.laonog.weixin.error.WxErrorException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <pre>
 * 群发消息服务类
 * Created by Binary Wang on 2017-8-16.
 * </pre>
 *
 * @author <a href="https://github.com/binarywang">Binary Wang</a>
 */
public class WxMpMassMessageServiceImpl implements WxMpMassMessageService {
  protected final Logger log = LoggerFactory.getLogger(this.getClass());
  private WxMpService wxMpService;

  public WxMpMassMessageServiceImpl(WxMpService wxMpService) {
    this.wxMpService = wxMpService;
  }

  @Override
  public WxMpMassUploadResult massNewsUpload(WxMpMassNews news) throws WxErrorException {
    String responseContent = this.wxMpService.post(MEDIA_UPLOAD_NEWS_URL, news.toJson());
    return WxMpMassUploadResult.fromJson(responseContent);
  }

  @Override
  public WxMpMassUploadResult massVideoUpload(WxMpMassVideo video) throws WxErrorException {
    String responseContent = this.wxMpService.post(MEDIA_UPLOAD_VIDEO_URL, video.toJson());
    return WxMpMassUploadResult.fromJson(responseContent);
  }

  @Override
  public WxMpMassSendResult massGroupMessageSend(WxMpMassTagMessage message) throws WxErrorException {
    String responseContent = this.wxMpService.post(WxMpMassMessageService.MESSAGE_MASS_SENDALL_URL, message.toJson());
    return WxMpMassSendResult.fromJson(responseContent);
  }

  @Override
  public WxMpMassSendResult massOpenIdsMessageSend(WxMpMassOpenIdsMessage message) throws WxErrorException {
    String responseContent = this.wxMpService.post(MESSAGE_MASS_SEND_URL, message.toJson());
    return WxMpMassSendResult.fromJson(responseContent);
  }

  @Override
  public WxMpMassSendResult massMessagePreview(WxMpMassPreviewMessage wxMpMassPreviewMessage) throws WxErrorException {
    String responseContent = this.wxMpService.post(MESSAGE_MASS_PREVIEW_URL, wxMpMassPreviewMessage.toJson());
    return WxMpMassSendResult.fromJson(responseContent);
  }

  @Override
  public void delete(Long msgId, Integer articleIndex) throws WxErrorException {
    JsonObject jsonObject = new JsonObject();
    jsonObject.addProperty("msg_id", msgId);
    jsonObject.addProperty("article_idx", articleIndex);
    this.wxMpService.post(MESSAGE_MASS_DELETE_URL, jsonObject.toString());
  }

}
