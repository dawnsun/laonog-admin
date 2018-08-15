package com.laonog.weixin.util.requestexecuter.material;

import com.laonog.weixin.bean.material.WxMpMaterialNews;
import com.laonog.weixin.util.http.RequestExecutor;
import com.laonog.weixin.util.http.RequestHttp;

public abstract class MaterialNewsInfoRequestExecutor<H, P> implements RequestExecutor<WxMpMaterialNews, String> {
  protected RequestHttp<H, P> requestHttp;

  public MaterialNewsInfoRequestExecutor(RequestHttp requestHttp) {
    this.requestHttp = requestHttp;
  }

  public static RequestExecutor<WxMpMaterialNews, String> create(RequestHttp requestHttp) {

        return new MaterialNewsInfoOkhttpRequestExecutor(requestHttp);

  }

}
