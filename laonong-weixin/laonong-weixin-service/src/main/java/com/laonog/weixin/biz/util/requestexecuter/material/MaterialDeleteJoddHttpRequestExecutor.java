package com.laonog.weixin.biz.util.requestexecuter.material;

import com.laonog.weixin.WxType;
import com.laonog.weixin.error.WxError;
import com.laonog.weixin.error.WxErrorException;
import com.laonog.weixin.util.http.RequestHttp;
import com.sun.deploy.net.proxy.ProxyInfo;

import java.io.IOException;

/**
 * Created by ecoolper on 2017/5/5.
 */
public class MaterialDeleteJoddHttpRequestExecutor extends MaterialDeleteRequestExecutor<HttpConnectionProvider, ProxyInfo> {
  public MaterialDeleteJoddHttpRequestExecutor(RequestHttp requestHttp) {
    super(requestHttp);
  }

  @Override
  public Boolean execute(String uri, String materialId) throws WxErrorException, IOException {
    HttpRequest request = HttpRequest.post(uri);
    if (requestHttp.getRequestHttpProxy() != null) {
      requestHttp.getRequestHttpClient().useProxy(requestHttp.getRequestHttpProxy());
    }
    request.withConnectionProvider(requestHttp.getRequestHttpClient());

    request.query("media_id", materialId);
    HttpResponse response = request.send();
    response.charset(StringPool.UTF_8);
    String responseContent = response.bodyText();
    WxError error = WxError.fromJson(responseContent, WxType.MP);
    if (error.getErrorCode() != 0) {
      throw new WxErrorException(error);
    } else {
      return true;
    }
  }
}
