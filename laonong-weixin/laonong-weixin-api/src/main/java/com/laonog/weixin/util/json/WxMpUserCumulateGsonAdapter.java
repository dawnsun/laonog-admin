package com.laonog.weixin.util.json;

import com.google.gson.*;
import com.laonog.weixin.bean.datacube.WxDataCubeUserCumulate;
import com.laonog.weixin.util.json.GsonHelper;
import org.apache.commons.lang3.time.FastDateFormat;

import java.lang.reflect.Type;
import java.text.ParseException;

/**
 * @author Daniel Qian
 */
public class WxMpUserCumulateGsonAdapter implements JsonDeserializer<WxDataCubeUserCumulate> {

  private static final FastDateFormat DATE_FORMAT = FastDateFormat
    .getInstance("yyyy-MM-dd");

  @Override
  public WxDataCubeUserCumulate deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws
      JsonParseException {
    WxDataCubeUserCumulate cumulate = new WxDataCubeUserCumulate();
    JsonObject summaryJsonObject = json.getAsJsonObject();

    try {
      String refDate = GsonHelper.getString(summaryJsonObject, "ref_date");
      if (refDate != null) {
        cumulate.setRefDate(DATE_FORMAT.parse(refDate));
      }
      cumulate.setCumulateUser(GsonHelper.getInteger(summaryJsonObject, "cumulate_user"));
    } catch (ParseException e) {
      throw new JsonParseException(e);
    }
    return cumulate;

  }

}
