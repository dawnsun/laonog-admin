package com.laonog.weixin.util.requestexecuter.material;

import com.laonog.weixin.WxType;
import com.laonog.weixin.error.WxError;
import com.laonog.weixin.error.WxErrorException;
import com.laonog.weixin.util.http.RequestHttp;
import com.laonog.weixin.util.http.okhttp.OkHttpProxyInfo;
import okhttp3.*;
import okio.BufferedSink;
import okio.Okio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

/**
 * Created by ecoolper on 2017/5/5.
 */
public class MaterialVoiceAndImageDownloadOkhttpRequestExecutor extends MaterialVoiceAndImageDownloadRequestExecutor<OkHttpClient, OkHttpProxyInfo> {
  private final Logger logger = LoggerFactory.getLogger(this.getClass());

  public MaterialVoiceAndImageDownloadOkhttpRequestExecutor(RequestHttp requestHttp, File tmpDirFile) {
    super(requestHttp, tmpDirFile);
  }

  @Override
  public InputStream execute(String uri, String materialId) throws WxErrorException, IOException {
    logger.debug("MaterialVoiceAndImageDownloadOkhttpRequestExecutor is running");
    OkHttpClient client = requestHttp.getRequestHttpClient();
    RequestBody requestBody = new FormBody.Builder().add("media_id", materialId).build();
    Request request = new Request.Builder().url(uri).get().post(requestBody).build();
    Response response = client.newCall(request).execute();
    String contentTypeHeader = response.header("Content-Type");
    if ("text/plain".equals(contentTypeHeader)) {
      String responseContent = response.body().string();
      throw new WxErrorException(WxError.fromJson(responseContent, WxType.MP));
    }
    try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream(); BufferedSink sink = Okio.buffer(Okio.sink(outputStream))) {
      sink.writeAll(response.body().source());
      return new ByteArrayInputStream(outputStream.toByteArray());
    }
  }
}
