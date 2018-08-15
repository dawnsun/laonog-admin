package com.laonog.weixin.api.impl;

import com.google.gson.JsonObject;
import com.laonog.weixin.api.WxMpService;
import com.laonog.weixin.api.WxMpWifiService;
import com.laonog.weixin.bean.wifi.WxMpWifiShopListResult;
import com.laonog.weixin.error.WxErrorException;

/**
 * <pre>
 *  Created by BinaryWang on 2018/6/10.
 * </pre>
 *
 * @author <a href="https://github.com/binarywang">Binary Wang</a>
 */
public class WxMpWifiServiceImpl implements WxMpWifiService {
  private WxMpService wxMpService;

  public WxMpWifiServiceImpl(WxMpService wxMpService) {
    this.wxMpService = wxMpService;
  }

  @Override
  public WxMpWifiShopListResult listShop(int pageIndex, int pageSize) throws WxErrorException {
    JsonObject json = new JsonObject();
    json.addProperty("pageindex", pageIndex);
    json.addProperty("pagesize", pageSize);
    final String result = this.wxMpService.post("https://api.weixin.qq.com/bizwifi/shop/list", json.toString());
    return WxMpWifiShopListResult.fromJson(result);
  }
}
