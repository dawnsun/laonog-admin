package com.laonog.weixin.util.voice;

import com.laonog.weixin.WxType;
import com.laonog.weixin.error.WxError;
import com.laonog.weixin.error.WxErrorException;
import com.laonog.weixin.util.http.RequestHttp;
import okhttp3.*;
import org.apache.http.HttpHost;
import org.apache.http.impl.client.CloseableHttpClient;

import java.io.File;
import java.io.IOException;

/**
 * <pre>
 *  Created by BinaryWang on 2018/6/9.
 * </pre>
 *
 * @author <a href="https://github.com/binarywang">Binary Wang</a>
 */
public class VoiceUploadOkHttpRequestExecutor extends VoiceUploadRequestExecutor<CloseableHttpClient, HttpHost> {
  public VoiceUploadOkHttpRequestExecutor(RequestHttp requestHttp) {
    super(requestHttp);
  }

  @Override
  public Boolean execute(String uri, File file) throws WxErrorException, IOException {
    if (file == null) {
      throw new WxErrorException(WxError.builder().errorCode(-1).errorMsg("文件对象为空").build());
    }

    //得到httpClient

    OkHttpClient client = requestHttp.getRequestHttpClient();

    MultipartBody.Builder bodyBuilder = new MultipartBody.Builder()
        .setType(MediaType.parse("multipart/form-data"))
        .addFormDataPart("media",
            file.getName(),
            RequestBody.create(MediaType.parse("application/octet-stream"), file));
    //Map<String, String> form = material.getForm();
    //if (form != null) {
    //  bodyBuilder.addFormDataPart("description", WxGsonBuilder.create().toJson(form));
    //}

    Request request = new Request.Builder().url(uri).post(bodyBuilder.build()).build();
    Response response = client.newCall(request).execute();
    String responseContent = response.body().string();
    WxError error = WxError.fromJson(responseContent, WxType.MP);
    if (error.getErrorCode() != 0) {
      throw new WxErrorException(error);
    } else {
      return true;
    }

    /*HttpPost httpPost = new HttpPost(uri);
    if (requestHttp.getRequestHttpProxy() != null) {
      RequestConfig config = RequestConfig.custom().setProxy(requestHttp.getRequestHttpProxy()).build();
      httpPost.setConfig(config);
    }

    HttpEntity entity = MultipartEntityBuilder
      .create()
      .addBinaryBody("media", data)
      .setMode(HttpMultipartMode.RFC6532)
      .build();
    httpPost.setEntity(entity);
    httpPost.setHeader("Content-Type", ContentType.MULTIPART_FORM_DATA.toString());

    try (CloseableHttpResponse response = requestHttp.getRequestHttpClient().execute(httpPost)) {
      String responseContent = Utf8ResponseHandler.INSTANCE.handleResponse(response);
      WxError error = WxError.fromJson(responseContent, WxType.MP);
      if (error.getErrorCode() != 0) {
        throw new WxErrorException(error);
      }

      return true;
    } finally {
      httpPost.releaseConnection();
    }*/
  }
}
