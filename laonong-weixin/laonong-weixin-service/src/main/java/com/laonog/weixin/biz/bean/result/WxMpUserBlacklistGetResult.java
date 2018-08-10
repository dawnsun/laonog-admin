package com.laonog.weixin.biz.bean.result;

import lombok.Data;
import com.laonog.weixin.biz.util.json.WxMpGsonBuilder;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author miller
 */
@Data
public class WxMpUserBlacklistGetResult implements Serializable {
  private static final long serialVersionUID = -8780216463588687626L;

  protected int total = -1;
  protected int count = -1;
  protected List<String> openidList = new ArrayList<>();
  protected String nextOpenid;

  public static WxMpUserBlacklistGetResult fromJson(String json) {
    return WxMpGsonBuilder.INSTANCE.create().fromJson(json, WxMpUserBlacklistGetResult.class);
  }

  @Override
  public String toString() {
    return WxMpGsonBuilder.INSTANCE.create().toJson(this);
  }
}
