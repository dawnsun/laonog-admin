package com.laonog.weixin.util.json;

import com.google.gson.*;
import com.laonog.weixin.bean.result.WxMpMassUploadResult;
import com.laonog.weixin.util.json.GsonHelper;

import java.lang.reflect.Type;

/**
 * @author Daniel Qian
 */
public class WxMpMassUploadResultAdapter implements JsonDeserializer<WxMpMassUploadResult> {

  @Override
  public WxMpMassUploadResult deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws
      JsonParseException {
    WxMpMassUploadResult uploadResult = new WxMpMassUploadResult();
    JsonObject uploadResultJsonObject = json.getAsJsonObject();

    if (uploadResultJsonObject.get("type") != null && !uploadResultJsonObject.get("type").isJsonNull()) {
      uploadResult.setType(GsonHelper.getAsString(uploadResultJsonObject.get("type")));
    }
    if (uploadResultJsonObject.get("media_id") != null && !uploadResultJsonObject.get("media_id").isJsonNull()) {
      uploadResult.setMediaId(GsonHelper.getAsString(uploadResultJsonObject.get("media_id")));
    }
    if (uploadResultJsonObject.get("created_at") != null && !uploadResultJsonObject.get("created_at").isJsonNull()) {
      uploadResult.setCreatedAt(GsonHelper.getAsPrimitiveLong(uploadResultJsonObject.get("created_at")));
    }
    return uploadResult;
  }

}
