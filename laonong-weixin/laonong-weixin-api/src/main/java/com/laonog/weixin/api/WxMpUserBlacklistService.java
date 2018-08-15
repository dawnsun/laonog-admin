package com.laonog.weixin.api;

import com.laonog.weixin.bean.result.WxMpUserBlacklistGetResult;
import com.laonog.weixin.error.WxErrorException;

import java.util.List;

/**
 * @author miller
 */
public interface WxMpUserBlacklistService {
  /**
   * <pre>
   * 获取公众号的黑名单列表
   * 详情请见http://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1471422259_pJMWA&token=&lang=zh_CN
   * </pre>
   */
  WxMpUserBlacklistGetResult getBlacklist(String nextOpenid) throws WxErrorException;

  /**
   * <pre>
   *   拉黑用户
   *   详情请见http://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1471422259_pJMWA&token=&lang=zh_CN
   * </pre>
   */
  void pushToBlacklist(List<String> openidList) throws WxErrorException;

  /**
   * <pre>
   *   取消拉黑用户
   *   详情请见http://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1471422259_pJMWA&token=&lang=zh_CN
   * </pre>
   */
  void pullFromBlacklist(List<String> openidList) throws WxErrorException;
}
