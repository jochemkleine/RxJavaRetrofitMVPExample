package kleine.com.reqtrader.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CoinList {

    @SerializedName("data")
    private List<Coin> coinList;

    public List<Coin> getCoinList() {
        return coinList;
    }
}
