package kleine.com.reqtrader.priceListing;

import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import kleine.com.reqtrader.util.Constants;
import kleine.com.reqtrader.util.Util;
import kleine.com.reqtrader.model.CoinList;
import kleine.com.reqtrader.repository.CoinRepository;

class PriceListingPresenter {

    private String TAG = "PriceListingPresenter";

    private final PriceListingView view;
    private final CompositeDisposable compositeDisposable;

    PriceListingPresenter(PriceListingView view){
        this.view = view;
        compositeDisposable = new CompositeDisposable();
    }

    void fetchCoinData(){
        Disposable disposable = CoinRepository.getInstance().getCmcLatestListing(1, 10, Constants.UNIT_USD)
                .map(CoinList::getCoinList)
                .flatMap(items -> Observable.fromIterable(items))
                .flatMap(item -> CoinRepository.getInstance().getCoinMetaData(item.getSymbol()))
                .map(Util::getCoinFromJson)
                .toList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(result -> {
                    view.displayCoinMetaData(result);
                }, error -> {
                    Log.e(TAG, error.toString());
                });

        compositeDisposable.add(disposable);
    }

    void disposeSubscriptions(){
        compositeDisposable.dispose();
    }
}
