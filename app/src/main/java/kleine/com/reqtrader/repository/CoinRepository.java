package kleine.com.reqtrader.repository;

import io.reactivex.Single;
import kleine.com.reqtrader.Constants;
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

    public Single<CoinList> getCmcLatestListing(int start, int limit, String convertUnit){
        if (coinMarketCapService == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(Constants.CMC_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
            coinMarketCapService = retrofit.create(CoinMarketCapService.class);
        }
        return coinMarketCapService.getLatestListings(Constants.API_KEY, Constants.SORT_MARKET_CAP, start, limit, "tokens", convertUnit);
    }
}
