package com.laonog.weixin.biz.bean.kefu.result;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import com.laonog.weixin.util.ToStringUtils;
import com.laonog.weixin.biz.util.json.WxMpGsonBuilder;

import java.io.Serializable;
import java.util.List;

/**
 * @author Binary Wang
 */
@Data
public class WxMpKfSessionWaitCaseList implements Serializable {
  private static final long serialVersionUID = 2432132626631361922L;

  /**
   * count 未接入会话数量
   */
  @SerializedName("count")
  private Long count;

  /**
   * waitcaselist 未接入会话列表，最多返回100条数据
   */
  @SerializedName("waitcaselist")
  private List<WxMpKfSession> kfSessionWaitCaseList;

  public static WxMpKfSessionWaitCaseList fromJson(String json) {
    return WxMpGsonBuilder.INSTANCE.create().fromJson(json,
      WxMpKfSessionWaitCaseList.class);
  }

  @Override
  public String toString() {
    return ToStringUtils.toSimpleString(this);
  }

}
