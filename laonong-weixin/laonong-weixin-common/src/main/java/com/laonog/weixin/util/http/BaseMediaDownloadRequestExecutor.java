package com.laonog.weixin.util.http;

import com.laonog.weixin.util.http.okhttp.OkHttpMediaDownloadRequestExecutor;

import java.io.File;

/**
 * 下载媒体文件请求执行器，请求的参数是String, 返回的结果是File
 * 视频文件不支持下载
 *
 * @author Daniel Qian
 */
public abstract class BaseMediaDownloadRequestExecutor<H, P> implements RequestExecutor<File, String> {
  protected RequestHttp<H, P> requestHttp;
  protected File tmpDirFile;

  public BaseMediaDownloadRequestExecutor(RequestHttp<H, P> requestHttp, File tmpDirFile) {
    this.requestHttp = requestHttp;
    this.tmpDirFile = tmpDirFile;
  }

  public static RequestExecutor<File, String> create(RequestHttp requestHttp, File tmpDirFile) {
    switch (requestHttp.getRequestType()) {
      case OK_HTTP:
        return new OkHttpMediaDownloadRequestExecutor(requestHttp, tmpDirFile);
      default:
        return null;
    }
  }

}
