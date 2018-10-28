package kleine.com.reqtrader.priceListing;

import java.util.List;

import kleine.com.reqtrader.model.Coin;

interface PriceListingView {

     void displayCoinData(List<Coin> coins);
}
