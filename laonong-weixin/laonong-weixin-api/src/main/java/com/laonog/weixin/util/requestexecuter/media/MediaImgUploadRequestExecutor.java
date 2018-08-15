package com.laonog.weixin.util.requestexecuter.media;

import com.laonog.weixin.bean.material.WxMediaImgUploadResult;
import com.laonog.weixin.util.http.RequestExecutor;
import com.laonog.weixin.util.http.RequestHttp;

import java.io.File;

/**
 * @author miller
 */
public abstract class MediaImgUploadRequestExecutor<H, P> implements RequestExecutor<WxMediaImgUploadResult, File> {
  protected RequestHttp<H, P> requestHttp;

  public MediaImgUploadRequestExecutor(RequestHttp requestHttp) {
    this.requestHttp = requestHttp;
  }

  public static RequestExecutor<WxMediaImgUploadResult, File> create(RequestHttp requestHttp) {

        return new MediaImgUploadOkhttpRequestExecutor(requestHttp);

  }

}
