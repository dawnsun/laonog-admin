package com.laonog.weixin.biz.util.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.laonog.weixin.biz.bean.*;
import com.laonog.weixin.biz.bean.datacube.WxDataCubeUserCumulate;
import com.laonog.weixin.biz.bean.datacube.WxDataCubeUserSummary;
import com.laonog.weixin.biz.bean.kefu.WxMpKefuMessage;
import com.laonog.weixin.biz.bean.material.*;
import com.laonog.weixin.biz.bean.membercard.WxMpMemberCardUpdateResult;
import com.laonog.weixin.biz.bean.membercard.WxMpMemberCardUserInfoResult;
import com.laonog.weixin.biz.bean.result.*;
import com.laonog.weixin.biz.bean.subscribe.WxMpSubscribeMessage;
import com.laonog.weixin.biz.bean.template.WxMpTemplateIndustry;
import com.laonog.weixin.biz.bean.template.WxMpTemplateMessage;

public class WxMpGsonBuilder {

  public static final GsonBuilder INSTANCE = new GsonBuilder();

  static {
    INSTANCE.disableHtmlEscaping();
    INSTANCE.registerTypeAdapter(WxMpKefuMessage.class, new WxMpKefuMessageGsonAdapter());
    INSTANCE.registerTypeAdapter(WxMpMassNews.class, new WxMpMassNewsGsonAdapter());
    INSTANCE.registerTypeAdapter(WxMpMassTagMessage.class, new WxMpMassTagMessageGsonAdapter());
    INSTANCE.registerTypeAdapter(WxMpMassOpenIdsMessage.class, new WxMpMassOpenIdsMessageGsonAdapter());
    INSTANCE.registerTypeAdapter(WxMpUser.class, new WxMpUserGsonAdapter());
    INSTANCE.registerTypeAdapter(WxMpUserList.class, new WxUserListGsonAdapter());
    INSTANCE.registerTypeAdapter(WxMpMassVideo.class, new WxMpMassVideoAdapter());
    INSTANCE.registerTypeAdapter(WxMpMassSendResult.class, new WxMpMassSendResultAdapter());
    INSTANCE.registerTypeAdapter(WxMpMassUploadResult.class, new WxMpMassUploadResultAdapter());
    INSTANCE.registerTypeAdapter(WxMpQrCodeTicket.class, new WxQrCodeTicketAdapter());
    INSTANCE.registerTypeAdapter(WxMpTemplateMessage.class, new WxMpTemplateMessageGsonAdapter());
    INSTANCE.registerTypeAdapter(WxMpSubscribeMessage.class, new WxMpSubscribeMessageGsonAdapter());
    INSTANCE.registerTypeAdapter(WxMpSemanticQueryResult.class, new WxMpSemanticQueryResultAdapter());
    INSTANCE.registerTypeAdapter(WxMpOAuth2AccessToken.class, new WxMpOAuth2AccessTokenAdapter());
    INSTANCE.registerTypeAdapter(WxDataCubeUserSummary.class, new WxMpUserSummaryGsonAdapter());
    INSTANCE.registerTypeAdapter(WxDataCubeUserCumulate.class, new WxMpUserCumulateGsonAdapter());
    INSTANCE.registerTypeAdapter(WxMpMaterialUploadResult.class, new WxMpMaterialUploadResultAdapter());
    INSTANCE.registerTypeAdapter(WxMpMaterialVideoInfoResult.class, new WxMpMaterialVideoInfoResultAdapter());
    INSTANCE.registerTypeAdapter(WxMpMassNews.WxMpMassNewsArticle.class, new WxMpMassNewsArticleGsonAdapter());
    INSTANCE.registerTypeAdapter(WxMpMaterialArticleUpdate.class, new WxMpMaterialArticleUpdateGsonAdapter());
    INSTANCE.registerTypeAdapter(WxMpMaterialCountResult.class, new WxMpMaterialCountResultAdapter());
    INSTANCE.registerTypeAdapter(WxMpMaterialNews.class, new WxMpMaterialNewsGsonAdapter());
    INSTANCE.registerTypeAdapter(WxMpMaterialNews.WxMpMaterialNewsArticle.class, new WxMpMaterialNewsArticleGsonAdapter());
    INSTANCE.registerTypeAdapter(WxMpMaterialNewsBatchGetResult.class, new WxMpMaterialNewsBatchGetGsonAdapter());
    INSTANCE.registerTypeAdapter(WxMpMaterialNewsBatchGetResult.WxMaterialNewsBatchGetNewsItem.class, new WxMpMaterialNewsBatchGetGsonItemAdapter());
    INSTANCE.registerTypeAdapter(WxMpMaterialFileBatchGetResult.class, new WxMpMaterialFileBatchGetGsonAdapter());
    INSTANCE.registerTypeAdapter(WxMpMaterialFileBatchGetResult.WxMaterialFileBatchGetNewsItem.class, new WxMpMaterialFileBatchGetGsonItemAdapter());
    INSTANCE.registerTypeAdapter(WxMpCardResult.class, new WxMpCardResultGsonAdapter());
    INSTANCE.registerTypeAdapter(WxMpCard.class, new WxMpCardGsonAdapter());
    INSTANCE.registerTypeAdapter(WxMpMassPreviewMessage.class, new WxMpMassPreviewMessageGsonAdapter());
    INSTANCE.registerTypeAdapter(WxMediaImgUploadResult.class, new WxMediaImgUploadResultGsonAdapter());
    INSTANCE.registerTypeAdapter(WxMpTemplateIndustry.class, new WxMpIndustryGsonAdapter());
    INSTANCE.registerTypeAdapter(WxMpUserBlacklistGetResult.class, new WxUserBlacklistGetResultGsonAdapter());
    INSTANCE.registerTypeAdapter(WxMpMemberCardUserInfoResult.class, new WxMpMemberCardUserInfoResultGsonAdapter());
    INSTANCE.registerTypeAdapter(WxMpMemberCardUpdateResult.class, new WxMpMemberCardUpdateResultGsonAdapter());
  }

  public static Gson create() {
    return INSTANCE.create();
  }

}
