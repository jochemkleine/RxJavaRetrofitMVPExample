package kleine.com.reqtrader.repository;

import com.google.gson.JsonObject;

import io.reactivex.Observable;
import kleine.com.reqtrader.model.CoinList;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface CoinMarketCapService {

    String customCmcHeader = "X-CMC_PRO_API_KEY";

    @GET("listings/latest")
    Observable<CoinList> getLatestListings(@Header(customCmcHeader) String apiKey,
                                       @Query("sort") String sortBy,
                                       @Query("start") int start,
                                       @Query("limit") int limit,
                                       @Query("cryptocurrency_type") String type,
                                       @Query("convert") String convert);

    @GET("info")
    Observable<JsonObject> getCoinMetaData(@Header(customCmcHeader) String apiKey,
                                           @Query("symbol") String coinSymbol);

}
