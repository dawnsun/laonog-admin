package com.laonog.weixin.biz.bean.material;

import lombok.Data;
import com.laonog.weixin.biz.util.json.WxMpGsonBuilder;

import java.io.Serializable;

@Data
public class WxMpMaterialVideoInfoResult implements Serializable {
  private static final long serialVersionUID = 1269131745333792202L;

  private String title;
  private String description;
  private String downUrl;

  public static WxMpMaterialVideoInfoResult fromJson(String json) {
    return WxMpGsonBuilder.create().fromJson(json, WxMpMaterialVideoInfoResult.class);
  }

}
