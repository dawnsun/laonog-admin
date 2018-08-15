package com.laonog.weixin.util.requestexecuter.material;

import com.laonog.weixin.bean.material.WxMpMaterialVideoInfoResult;
import com.laonog.weixin.util.http.RequestExecutor;
import com.laonog.weixin.util.http.RequestHttp;

public abstract class MaterialVideoInfoRequestExecutor<H, P> implements
    RequestExecutor<WxMpMaterialVideoInfoResult, String> {
  protected RequestHttp<H, P> requestHttp;

  public MaterialVideoInfoRequestExecutor(RequestHttp requestHttp) {
          this.requestHttp = requestHttp;
        }

        public static RequestExecutor<WxMpMaterialVideoInfoResult, String> create(RequestHttp requestHttp) {

              return new MaterialVideoInfoOkhttpRequestExecutor(requestHttp);

        }

      }
