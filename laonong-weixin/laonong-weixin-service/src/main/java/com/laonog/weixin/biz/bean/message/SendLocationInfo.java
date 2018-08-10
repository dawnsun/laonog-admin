package com.laonog.weixin.biz.bean.message;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import lombok.Data;
import com.laonog.weixin.util.ToStringUtils;
import com.laonog.weixin.util.xml.XStreamCDataConverter;

import java.io.Serializable;

/**
 * <pre>
 *  Created by BinaryWang on 2017/5/4.
 * </pre>
 *
 * @author Binary Wang
 */
@XStreamAlias("SendLocationInfo")
@Data
public class SendLocationInfo implements Serializable {
  private static final long serialVersionUID = 6633214140499161130L;

  @XStreamAlias("Location_X")
  @XStreamConverter(value = XStreamCDataConverter.class)
  private String locationX;

  @XStreamAlias("Location_Y")
  @XStreamConverter(value = XStreamCDataConverter.class)
  private String locationY;

  @XStreamAlias("Scale")
  @XStreamConverter(value = XStreamCDataConverter.class)
  private String scale;

  @XStreamAlias("Label")
  @XStreamConverter(value = XStreamCDataConverter.class)
  private String label;

  @XStreamAlias("Poiname")
  @XStreamConverter(value = XStreamCDataConverter.class)
  private String poiName;

  @Override
  public String toString() {
    return ToStringUtils.toSimpleString(this);
  }
}
