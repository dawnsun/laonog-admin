package com.laonog.weixin.util.voice;

import com.laonog.weixin.util.http.RequestExecutor;
import com.laonog.weixin.util.http.RequestHttp;

import java.io.File;

/**
 * <pre>
 *  Created by BinaryWang on 2018/6/9.
 * </pre>
 *
 * @author <a href="https://github.com/binarywang">Binary Wang</a>
 */
public abstract class VoiceUploadRequestExecutor<H, P> implements RequestExecutor<Boolean, File> {
  protected RequestHttp<H, P> requestHttp;

  public VoiceUploadRequestExecutor(RequestHttp requestHttp) {
    this.requestHttp = requestHttp;
  }

  public static RequestExecutor<Boolean, File> create(RequestHttp requestHttp) {
        return new VoiceUploadOkHttpRequestExecutor(requestHttp);

  }

}
