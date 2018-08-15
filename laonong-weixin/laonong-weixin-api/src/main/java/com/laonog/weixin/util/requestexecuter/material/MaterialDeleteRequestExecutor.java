package com.laonog.weixin.util.requestexecuter.material;

import com.laonog.weixin.util.http.RequestExecutor;
import com.laonog.weixin.util.http.RequestHttp;

public abstract class MaterialDeleteRequestExecutor<H, P> implements RequestExecutor<Boolean, String> {
  protected RequestHttp<H, P> requestHttp;

  public MaterialDeleteRequestExecutor(RequestHttp requestHttp) {
    this.requestHttp = requestHttp;
  }

  public static RequestExecutor<Boolean, String> create(RequestHttp requestHttp) {

        return new MaterialDeleteOkhttpRequestExecutor(requestHttp);

  }

}
