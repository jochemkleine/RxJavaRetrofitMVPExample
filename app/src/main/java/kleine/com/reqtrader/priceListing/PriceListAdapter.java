package kleine.com.reqtrader.priceListing;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import java.util.List;

import kleine.com.reqtrader.R;
import kleine.com.reqtrader.model.CoinMetaData;

public class PriceListAdapter extends RecyclerView.Adapter<PriceListViewholder> {

    private List<CoinMetaData> coins;

    PriceListAdapter(List<CoinMetaData> coins){
        this.coins = coins;
    }

    @NonNull
    @Override
    public PriceListViewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new PriceListViewholder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.coin_item, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull PriceListViewholder holder, int i) {
        holder.name.setText(coins.get(i).getName());
        holder.symbol.setText(coins.get(i).getSymbol());
        Picasso.get().load(coins.get(i).getLogo()).into(holder.logo);
    }

    @Override
    public int getItemCount() {
        return coins.size();
    }

    void setCoinList(List<CoinMetaData> coins) {
        this.coins = coins;
    }
}
