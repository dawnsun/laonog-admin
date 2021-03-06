package com.laonog.weixin.util.json;

import com.google.gson.*;
import com.laonog.weixin.WxConsts;
import com.laonog.weixin.bean.kefu.WxMpKefuMessage;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Type;

public class WxMpKefuMessageGsonAdapter implements JsonSerializer<WxMpKefuMessage> {

  @Override
  public JsonElement serialize(WxMpKefuMessage message, Type typeOfSrc, JsonSerializationContext context) {
    JsonObject messageJson = new JsonObject();
    messageJson.addProperty("touser", message.getToUser());
    messageJson.addProperty("msgtype", message.getMsgType());

    if (WxConsts.KefuMsgType.TEXT.equals(message.getMsgType())) {
      JsonObject text = new JsonObject();
      text.addProperty("content", message.getContent());
      messageJson.add("text", text);
    }

    if (WxConsts.KefuMsgType.IMAGE.equals(message.getMsgType())) {
      JsonObject image = new JsonObject();
      image.addProperty("media_id", message.getMediaId());
      messageJson.add("image", image);
    }

    if (WxConsts.KefuMsgType.VOICE.equals(message.getMsgType())) {
      JsonObject voice = new JsonObject();
      voice.addProperty("media_id", message.getMediaId());
      messageJson.add("voice", voice);
    }

    if (WxConsts.KefuMsgType.VIDEO.equals(message.getMsgType())) {
      JsonObject video = new JsonObject();
      video.addProperty("media_id", message.getMediaId());
      video.addProperty("thumb_media_id", message.getThumbMediaId());
      video.addProperty("title", message.getTitle());
      video.addProperty("description", message.getDescription());
      messageJson.add("video", video);
    }

    if (WxConsts.KefuMsgType.MUSIC.equals(message.getMsgType())) {
      JsonObject music = new JsonObject();
      music.addProperty("title", message.getTitle());
      music.addProperty("description", message.getDescription());
      music.addProperty("thumb_media_id", message.getThumbMediaId());
      music.addProperty("musicurl", message.getMusicUrl());
      music.addProperty("hqmusicurl", message.getHqMusicUrl());
      messageJson.add("music", music);
    }

    if (WxConsts.KefuMsgType.NEWS.equals(message.getMsgType())) {
      JsonObject newsJsonObject = new JsonObject();
      JsonArray articleJsonArray = new JsonArray();
      for (WxMpKefuMessage.WxArticle article : message.getArticles()) {
        JsonObject articleJson = new JsonObject();
        articleJson.addProperty("title", article.getTitle());
        articleJson.addProperty("description", article.getDescription());
        articleJson.addProperty("url", article.getUrl());
        articleJson.addProperty("picurl", article.getPicUrl());
        articleJsonArray.add(articleJson);
      }
      newsJsonObject.add("articles", articleJsonArray);
      messageJson.add("news", newsJsonObject);
    }

    if (WxConsts.KefuMsgType.MPNEWS.equals(message.getMsgType())) {
      JsonObject json = new JsonObject();
      json.addProperty("media_id", message.getMpNewsMediaId());
      messageJson.add("mpnews", json);
    }

    if (WxConsts.KefuMsgType.WXCARD.equals(message.getMsgType())) {
      JsonObject wxcard = new JsonObject();
      wxcard.addProperty("card_id", message.getCardId());
      messageJson.add("wxcard", wxcard);
    }

    if (WxConsts.KefuMsgType.MINIPROGRAMPAGE.equals(message.getMsgType())) {
      JsonObject miniProgramPage = new JsonObject();
      miniProgramPage.addProperty("title", message.getTitle());
      miniProgramPage.addProperty("appid", message.getMiniProgramAppId());
      miniProgramPage.addProperty("pagepath", message.getMiniProgramPagePath());
      miniProgramPage.addProperty("thumb_media_id", message.getThumbMediaId());
      messageJson.add("miniprogrampage", miniProgramPage);
    }

    if (StringUtils.isNotBlank(message.getKfAccount())) {
      JsonObject newsJsonObject = new JsonObject();
      newsJsonObject.addProperty("kf_account", message.getKfAccount());
      messageJson.add("customservice", newsJsonObject);
    }

    return messageJson;
  }

}
