package kleine.com.reqtrader.model;

import com.google.gson.annotations.SerializedName;

public class Coin {

    @SerializedName("id")
    private String id;

    @SerializedName("name")
    private String name;

    @SerializedName("symbol")
    private String symbol;

    @SerializedName("logo")
    private String logo;


    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getLogo() {
        return logo;
    }
}
