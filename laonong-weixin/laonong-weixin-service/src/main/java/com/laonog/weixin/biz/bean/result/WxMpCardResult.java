package com.laonog.weixin.biz.bean.result;

import com.laonog.weixin.biz.bean.WxMpCard;
import com.laonog.weixin.util.ToStringUtils;
import lombok.Data;

import java.io.Serializable;

/**
 * 卡券查询Code，核销Code接口返回结果
 *
 * @author YuJian
 * @version 15/11/11
 */
@Data
public class WxMpCardResult implements Serializable {
  private static final long serialVersionUID = -7950878428289035637L;

  private String errorCode;

  private String errorMsg;

  private String openId;

  private WxMpCard card;

  private String userCardStatus;

  private Boolean canConsume;

  @Override
  public String toString() {
    return ToStringUtils.toSimpleString(this);
  }

}
