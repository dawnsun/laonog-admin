package com.laonog.weixin.biz.util.json;

import com.google.gson.*;
import com.laonog.weixin.biz.bean.WxMpCard;
import com.laonog.weixin.util.json.GsonHelper;

import java.lang.reflect.Type;

/**
 * Created by YuJian on 15/11/11.
 *
 * @author YuJian
 * @version 15/11/11
 */
public class WxMpCardGsonAdapter implements JsonDeserializer<WxMpCard> {

  @Override
  public WxMpCard deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext
    jsonDeserializationContext) throws JsonParseException {
    WxMpCard card = new WxMpCard();
    JsonObject jsonObject = jsonElement.getAsJsonObject();

    card.setCardId(GsonHelper.getString(jsonObject, "card_id"));
    card.setBeginTime(GsonHelper.getLong(jsonObject, "begin_time"));
    card.setEndTime(GsonHelper.getLong(jsonObject, "end_time"));

    return card;
  }

}
