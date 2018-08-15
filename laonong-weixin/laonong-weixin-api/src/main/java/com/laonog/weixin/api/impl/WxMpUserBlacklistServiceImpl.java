package com.laonog.weixin.api.impl;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.laonog.weixin.api.WxMpService;
import com.laonog.weixin.api.WxMpUserBlacklistService;
import com.laonog.weixin.bean.result.WxMpUserBlacklistGetResult;
import com.laonog.weixin.error.WxErrorException;
import com.laonog.weixin.util.http.SimplePostRequestExecutor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author miller
 */
public class WxMpUserBlacklistServiceImpl implements WxMpUserBlacklistService {
  private static final String API_BLACKLIST_PREFIX = "https://api.weixin.qq.com/cgi-bin/tags/members";
  private WxMpService wxMpService;

  public WxMpUserBlacklistServiceImpl(WxMpService wxMpService) {
    this.wxMpService = wxMpService;
  }

  @Override
  public WxMpUserBlacklistGetResult getBlacklist(String nextOpenid) throws WxErrorException {
    JsonObject jsonObject = new JsonObject();
    jsonObject.addProperty("begin_openid", nextOpenid);
    String url = API_BLACKLIST_PREFIX + "/getblacklist";
    String responseContent = this.wxMpService.execute(SimplePostRequestExecutor.create(this.wxMpService.getRequestHttp()), url, jsonObject.toString());
    return WxMpUserBlacklistGetResult.fromJson(responseContent);
  }

  @Override
  public void pushToBlacklist(List<String> openidList) throws WxErrorException {
    Map<String, Object> map = new HashMap<>();
    map.put("openid_list", openidList);
    String url = API_BLACKLIST_PREFIX + "/batchblacklist";
    this.wxMpService.execute(SimplePostRequestExecutor.create(this.wxMpService.getRequestHttp()), url, new Gson().toJson(map));
  }

  @Override
  public void pullFromBlacklist(List<String> openidList) throws WxErrorException {
    Map<String, Object> map = new HashMap<>();
    map.put("openid_list", openidList);
    String url = API_BLACKLIST_PREFIX + "/batchunblacklist";
    this.wxMpService.execute(SimplePostRequestExecutor.create(this.wxMpService.getRequestHttp()), url, new Gson().toJson(map));
  }
}
