package com.laonog.weixin.biz.bean.shake;

import com.google.gson.JsonObject;
import com.laonog.weixin.biz.util.json.WxMpGsonBuilder;
import com.laonog.weixin.util.json.GsonHelper;
import lombok.Data;

import java.io.Serializable;

@Data
public class WxMpShakeAroundPageAddResult implements Serializable {
  private Integer errorCode;
  private String errorMsg;
  private Integer pageId;
  public static WxMpShakeAroundPageAddResult fromJson(String json) {
    JsonObject jsonObject = WxMpGsonBuilder.INSTANCE.create().fromJson(json, JsonObject.class);
    WxMpShakeAroundPageAddResult result = new WxMpShakeAroundPageAddResult();
    result.setErrorCode(GsonHelper.getInteger(jsonObject, "errcode"));
    result.setErrorMsg(GsonHelper.getString(jsonObject, "errmsg"));
    jsonObject = jsonObject.getAsJsonObject("data");
    if(jsonObject != null){
      result.setPageId(GsonHelper.getInteger(jsonObject, "page_id"));
    }
    return result;
  }
}
