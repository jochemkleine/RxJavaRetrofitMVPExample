package kleine.com.reqtrader.util;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.Map;

import kleine.com.reqtrader.model.CoinMetaData;

public class Util {

    static String TAG = "Util";

    public static CoinMetaData getCoinFromJson(JsonObject contents) {
        contents = contents.getAsJsonObject("data");
        String coinSymbol = "";
        for (Map.Entry<String, JsonElement> entry : contents.entrySet()) {
            coinSymbol = entry.getKey();
        }
        JsonObject coinObject = contents.getAsJsonObject(coinSymbol);
        Log.d(TAG, coinObject.toString());

        return new Gson().fromJson(coinObject, CoinMetaData.class);
    }
}
