package com.laonog.weixin.util.json;

import com.google.gson.*;
import com.laonog.weixin.bean.material.WxMpMaterialUploadResult;
import com.laonog.weixin.util.json.GsonHelper;

import java.lang.reflect.Type;

/**
 * @author codepiano
 */
public class WxMpMaterialUploadResultAdapter implements JsonDeserializer<WxMpMaterialUploadResult> {

  @Override
  public WxMpMaterialUploadResult deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws
      JsonParseException {
    WxMpMaterialUploadResult uploadResult = new WxMpMaterialUploadResult();
    JsonObject uploadResultJsonObject = json.getAsJsonObject();

    if (uploadResultJsonObject.get("url") != null && !uploadResultJsonObject.get("url").isJsonNull()) {
      uploadResult.setUrl(GsonHelper.getAsString(uploadResultJsonObject.get("url")));
    }
    if (uploadResultJsonObject.get("media_id") != null && !uploadResultJsonObject.get("media_id").isJsonNull()) {
      uploadResult.setMediaId(GsonHelper.getAsString(uploadResultJsonObject.get("media_id")));
    }
    return uploadResult;
  }

}
