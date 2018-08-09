package com.laonog.weixin.util.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.laonog.weixin.bean.WxAccessToken;
import com.laonog.weixin.bean.WxMediaUploadResult;
import com.laonog.weixin.bean.WxMenu;
import com.laonog.weixin.error.WxError;

public class WxGsonBuilder {

  public static final GsonBuilder INSTANCE = new GsonBuilder();

  static {
    INSTANCE.disableHtmlEscaping();
    INSTANCE.registerTypeAdapter(WxAccessToken.class, new WxAccessTokenAdapter());
    INSTANCE.registerTypeAdapter(WxError.class, new WxErrorAdapter());
    INSTANCE.registerTypeAdapter(WxMenu.class, new WxMenuGsonAdapter());
    INSTANCE.registerTypeAdapter(WxMediaUploadResult.class, new WxMediaUploadResultAdapter());
  }

  public static Gson create() {
    return INSTANCE.create();
  }

}
