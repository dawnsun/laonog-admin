package com.laonog.weixin.biz.bean.material;

import lombok.Data;
import com.laonog.weixin.biz.util.json.WxMpGsonBuilder;

import java.io.Serializable;

@Data
public class WxMpMaterialArticleUpdate implements Serializable {
  private static final long serialVersionUID = -7611963949517780270L;

  private String mediaId;
  private int index;
  private WxMpMaterialNews.WxMpMaterialNewsArticle articles;

  public String toJson() {
    return WxMpGsonBuilder.create().toJson(this);
  }
}
