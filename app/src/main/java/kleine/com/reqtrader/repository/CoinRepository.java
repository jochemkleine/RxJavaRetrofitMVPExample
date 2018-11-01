package kleine.com.reqtrader.repository;

import com.google.gson.JsonObject;

import io.reactivex.Observable;
import kleine.com.reqtrader.Util.Constants;
import kleine.com.reqtrader.model.CoinList;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class CoinRepository {

    private static CoinRepository coinRepository;

    private CoinMarketCapService coinMarketCapService;

    public static CoinRepository getInstance() {
        if (coinRepository == null) {
            return new CoinRepository();
        } else {
            return coinRepository;
        }
    }

    public Observable<CoinList> getCmcLatestListing(int start, int limit, String convertUnit){
        checkCmcRetrofitInstantiation();
        return coinMarketCapService.getLatestListings(Constants.API_KEY, Constants.SORT_MARKET_CAP, start, limit, "tokens", convertUnit);
    }

    public Observable<JsonObject> getCoinMetaData(String symbol){
        checkCmcRetrofitInstantiation();
        return coinMarketCapService.getCoinMetaData(Constants.API_KEY, symbol);
    }

    public void checkCmcRetrofitInstantiation(){
        if (coinMarketCapService == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(Constants.CMC_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
            coinMarketCapService = retrofit.create(CoinMarketCapService.class);
        }
    }
}
