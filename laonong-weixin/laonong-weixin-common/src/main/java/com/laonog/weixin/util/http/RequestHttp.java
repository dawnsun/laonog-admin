package com.laonog.weixin.util.http;

import okhttp3.OkHttpClient;

/**
 * Created by ecoolper on 2017/4/22.
 */
public interface RequestHttp<H, P> {

  /**
   * 返回httpClient
   *
   */
  OkHttpClient getRequestHttpClient();

  /**
   * 返回httpProxy
   *
   */
  P getRequestHttpProxy();

  HttpType getRequestType();

}
