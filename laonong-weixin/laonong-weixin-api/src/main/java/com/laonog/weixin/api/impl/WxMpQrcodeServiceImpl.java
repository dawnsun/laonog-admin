package com.laonog.weixin.api.impl;

import com.google.gson.JsonObject;
import com.laonog.weixin.api.WxMpQrcodeService;
import com.laonog.weixin.api.WxMpService;
import com.laonog.weixin.bean.result.WxMpQrCodeTicket;
import com.laonog.weixin.error.WxError;
import com.laonog.weixin.error.WxErrorException;
import com.laonog.weixin.util.requestexecuter.qrcode.QrCodeRequestExecutor;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/**
 * Created by Binary Wang on 2016/7/21.
 */
public class WxMpQrcodeServiceImpl implements WxMpQrcodeService {
  private static final String API_URL_PREFIX = "https://api.weixin.qq.com/cgi-bin/qrcode";
  private WxMpService wxMpService;

  public WxMpQrcodeServiceImpl(WxMpService wxMpService) {
    this.wxMpService = wxMpService;
  }

  @Override
  public WxMpQrCodeTicket qrCodeCreateTmpTicket(int sceneId, Integer expireSeconds) throws WxErrorException {
    if (sceneId == 0) {
      throw new WxErrorException(WxError.builder().errorCode(-1).errorMsg("临时二维码场景值不能为0！").build());
    }

    //expireSeconds 该二维码有效时间，以秒为单位。 最大不超过2592000（即30天），此字段如果不填，则默认有效期为30秒。
    if (expireSeconds != null && expireSeconds > 2592000) {
      throw new WxErrorException(WxError.builder().errorCode(-1)
        .errorMsg("临时二维码有效时间最大不能超过2592000（即30天）！").build());
    }

    if (expireSeconds == null) {
      expireSeconds = 30;
    }

    String url = API_URL_PREFIX + "/create";
    JsonObject json = new JsonObject();
    json.addProperty("action_name", "QR_SCENE");
    json.addProperty("expire_seconds", expireSeconds);

    JsonObject actionInfo = new JsonObject();
    JsonObject scene = new JsonObject();
    scene.addProperty("scene_id", sceneId);
    actionInfo.add("scene", scene);
    json.add("action_info", actionInfo);
    String responseContent = this.wxMpService.post(url, json.toString());
    return WxMpQrCodeTicket.fromJson(responseContent);
  }


  @Override
  public WxMpQrCodeTicket qrCodeCreateTmpTicket(String sceneStr, Integer expireSeconds) throws WxErrorException {
    if (StringUtils.isBlank(sceneStr)) {
      throw new WxErrorException(WxError.builder().errorCode(-1).errorMsg("临时二维码场景值不能为空！").build());
    }

    //expireSeconds 该二维码有效时间，以秒为单位。 最大不超过2592000（即30天），此字段如果不填，则默认有效期为30秒。
    if (expireSeconds != null && expireSeconds > 2592000) {
      throw new WxErrorException(WxError.builder().errorCode(-1)
        .errorMsg("临时二维码有效时间最大不能超过2592000（即30天）！").build());
    }

    if (expireSeconds == null) {
      expireSeconds = 30;
    }

    String url = API_URL_PREFIX + "/create";
    JsonObject json = new JsonObject();
    json.addProperty("action_name", "QR_STR_SCENE");
    json.addProperty("expire_seconds", expireSeconds);

    JsonObject actionInfo = new JsonObject();
    JsonObject scene = new JsonObject();
    scene.addProperty("scene_str", sceneStr);
    actionInfo.add("scene", scene);
    json.add("action_info", actionInfo);
    String responseContent = this.wxMpService.post(url, json.toString());
    return WxMpQrCodeTicket.fromJson(responseContent);
  }


  @Override
  public WxMpQrCodeTicket qrCodeCreateLastTicket(int sceneId) throws WxErrorException {
    if (sceneId < 1 || sceneId > 100000) {
      throw new WxErrorException(WxError.builder().errorCode(-1)
        .errorMsg("永久二维码的场景值目前只支持1--100000！")
        .build());
    }

    String url = API_URL_PREFIX + "/create";
    JsonObject json = new JsonObject();
    json.addProperty("action_name", "QR_LIMIT_SCENE");
    JsonObject actionInfo = new JsonObject();
    JsonObject scene = new JsonObject();
    scene.addProperty("scene_id", sceneId);
    actionInfo.add("scene", scene);
    json.add("action_info", actionInfo);
    String responseContent = this.wxMpService.post(url, json.toString());
    return WxMpQrCodeTicket.fromJson(responseContent);
  }

  @Override
  public WxMpQrCodeTicket qrCodeCreateLastTicket(String sceneStr) throws WxErrorException {
    String url = API_URL_PREFIX + "/create";
    JsonObject json = new JsonObject();
    json.addProperty("action_name", "QR_LIMIT_STR_SCENE");
    JsonObject actionInfo = new JsonObject();
    JsonObject scene = new JsonObject();
    scene.addProperty("scene_str", sceneStr);
    actionInfo.add("scene", scene);
    json.add("action_info", actionInfo);
    String responseContent = this.wxMpService.post(url, json.toString());
    return WxMpQrCodeTicket.fromJson(responseContent);
  }

  @Override
  public File qrCodePicture(WxMpQrCodeTicket ticket) throws WxErrorException {
    String url = "https://mp.weixin.qq.com/cgi-bin/showqrcode";
    return this.wxMpService.execute(QrCodeRequestExecutor.create(this.wxMpService.getRequestHttp()), url, ticket);
  }

  @Override
  public String qrCodePictureUrl(String ticket, boolean needShortUrl) throws WxErrorException {
    String url = "https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=%s";
    try {
      String resultUrl = String.format(url,
        URLEncoder.encode(ticket, StandardCharsets.UTF_8.name()));
      if (needShortUrl) {
        return this.wxMpService.shortUrl(resultUrl);
      }

      return resultUrl;
    } catch (UnsupportedEncodingException e) {
      throw new WxErrorException(WxError.builder().errorCode(-1).errorMsg(e.getMessage()).build());
    }
  }

  @Override
  public String qrCodePictureUrl(String ticket) throws WxErrorException {
    return qrCodePictureUrl(ticket, false);
  }

}
