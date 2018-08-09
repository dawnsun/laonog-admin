package com.laonog.weixin.biz.util.json;

import com.google.gson.*;
import com.laonog.weixin.biz.bean.template.WxMpTemplateIndustry;
import com.laonog.weixin.util.json.GsonHelper;

import java.lang.reflect.Type;

/**
 * @author miller
 */
public class WxMpIndustryGsonAdapter
  implements JsonSerializer<WxMpTemplateIndustry>, JsonDeserializer<WxMpTemplateIndustry> {
  private static WxMpTemplateIndustry.Industry convertFromJson(JsonObject json) {
    WxMpTemplateIndustry.Industry industry = new WxMpTemplateIndustry.Industry();
    industry.setFirstClass(GsonHelper.getString(json, "first_class"));
    industry.setSecondClass(GsonHelper.getString(json, "second_class"));
    return industry;
  }

  @Override
  public JsonElement serialize(WxMpTemplateIndustry wxMpIndustry, Type type,
                               JsonSerializationContext jsonSerializationContext) {
    JsonObject json = new JsonObject();
    json.addProperty("industry_id1", wxMpIndustry.getPrimaryIndustry().getId());
    json.addProperty("industry_id2", wxMpIndustry.getSecondIndustry().getId());
    return json;
  }

  @Override
  public WxMpTemplateIndustry deserialize(JsonElement jsonElement, Type type,
                                          JsonDeserializationContext jsonDeserializationContext)
    throws JsonParseException {
    WxMpTemplateIndustry wxMpIndustry = new WxMpTemplateIndustry();
    JsonObject primaryIndustry = jsonElement.getAsJsonObject()
      .get("primary_industry").getAsJsonObject();
    wxMpIndustry.setPrimaryIndustry(convertFromJson(primaryIndustry));
    JsonObject secondaryIndustry = jsonElement.getAsJsonObject()
      .get("secondary_industry").getAsJsonObject();
    wxMpIndustry.setSecondIndustry(convertFromJson(secondaryIndustry));
    return wxMpIndustry;
  }
}