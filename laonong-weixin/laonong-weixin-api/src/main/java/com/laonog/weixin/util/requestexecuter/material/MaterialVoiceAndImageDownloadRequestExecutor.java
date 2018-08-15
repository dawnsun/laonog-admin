package com.laonog.weixin.util.requestexecuter.material;

import com.laonog.weixin.util.http.RequestExecutor;
import com.laonog.weixin.util.http.RequestHttp;

import java.io.File;
import java.io.InputStream;

public abstract class MaterialVoiceAndImageDownloadRequestExecutor<H, P>
  implements RequestExecutor<InputStream, String> {
  protected RequestHttp<H, P> requestHttp;
  protected File tmpDirFile;

  public MaterialVoiceAndImageDownloadRequestExecutor(RequestHttp requestHttp, File tmpDirFile) {
    this.requestHttp = requestHttp;
    this.tmpDirFile = tmpDirFile;
  }

  public static RequestExecutor<InputStream, String> create(RequestHttp requestHttp, File tmpDirFile) {

        return new MaterialVoiceAndImageDownloadOkhttpRequestExecutor(requestHttp, tmpDirFile);

  }


}
