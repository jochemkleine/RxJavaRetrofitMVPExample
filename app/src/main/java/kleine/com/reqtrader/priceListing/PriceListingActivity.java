package kleine.com.reqtrader.priceListing;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import kleine.com.reqtrader.R;
import kleine.com.reqtrader.model.CoinMetaData;


public class PriceListingActivity extends AppCompatActivity implements PriceListingView {

    private PriceListingPresenter presenter;
    private String TAG = "PriceListingActivity";
    private PriceListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter = new PriceListingPresenter(this);
        presenter.fetchCoinData();
        
        initRecyclerView();
    }


    private void initRecyclerView() {
        adapter = new PriceListAdapter(new ArrayList<CoinMetaData>());
        RecyclerView coinRecyclerview = findViewById(R.id.coinRecyclerView);
        LinearLayoutManager llm = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        coinRecyclerview.setLayoutManager(llm);
        coinRecyclerview.setAdapter(adapter);
    }

    @Override
    public void displayCoinMetaData(List<CoinMetaData> coinMetaDataList) {
        adapter.setCoinList(coinMetaDataList);
        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.disposeSubscriptions();
    }
}
