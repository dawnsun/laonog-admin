package com.laonog.weixin.util.json;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.laonog.weixin.WxConsts;
import com.laonog.weixin.bean.WxMpMassPreviewMessage;

import java.lang.reflect.Type;

/**
 * @author miller
 */
public class WxMpMassPreviewMessageGsonAdapter implements JsonSerializer<WxMpMassPreviewMessage> {
  @Override
  public JsonElement serialize(WxMpMassPreviewMessage wxMpMassPreviewMessage, Type type, JsonSerializationContext jsonSerializationContext) {
    JsonObject jsonObject = new JsonObject();
    jsonObject.addProperty("towxname", wxMpMassPreviewMessage.getToWxUserName());
    jsonObject.addProperty("touser", wxMpMassPreviewMessage.getToWxUserOpenid());
    if (WxConsts.MassMsgType.MPNEWS.equals(wxMpMassPreviewMessage.getMsgType())) {
      JsonObject news = new JsonObject();
      news.addProperty("media_id", wxMpMassPreviewMessage.getMediaId());
      jsonObject.add(WxConsts.MassMsgType.MPNEWS, news);
    }
    if (WxConsts.MassMsgType.TEXT.equals(wxMpMassPreviewMessage.getMsgType())) {
      JsonObject sub = new JsonObject();
      sub.addProperty("content", wxMpMassPreviewMessage.getContent());
      jsonObject.add(WxConsts.MassMsgType.TEXT, sub);
    }
    if (WxConsts.MassMsgType.VOICE.equals(wxMpMassPreviewMessage.getMsgType())) {
      JsonObject sub = new JsonObject();
      sub.addProperty("media_id", wxMpMassPreviewMessage.getMediaId());
      jsonObject.add(WxConsts.MassMsgType.VOICE, sub);
    }
    if (WxConsts.MassMsgType.IMAGE.equals(wxMpMassPreviewMessage.getMsgType())) {
      JsonObject sub = new JsonObject();
      sub.addProperty("media_id", wxMpMassPreviewMessage.getMediaId());
      jsonObject.add(WxConsts.MassMsgType.IMAGE, sub);
    }
    if (WxConsts.MassMsgType.MPVIDEO.equals(wxMpMassPreviewMessage.getMsgType())) {
      JsonObject sub = new JsonObject();
      sub.addProperty("media_id", wxMpMassPreviewMessage.getMediaId());
      jsonObject.add(WxConsts.MassMsgType.MPVIDEO, sub);
    }
    jsonObject.addProperty("msgtype", wxMpMassPreviewMessage.getMsgType());
    return jsonObject;
  }
}
