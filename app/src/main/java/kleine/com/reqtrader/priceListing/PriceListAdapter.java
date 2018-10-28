package kleine.com.reqtrader.priceListing;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

import kleine.com.reqtrader.R;
import kleine.com.reqtrader.model.Coin;

public class PriceListAdapter extends RecyclerView.Adapter<PriceListViewholder> {

    private  List<Coin> coins;

    PriceListAdapter(List<Coin> coins){
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
        holder.symbol.setText(coins.get(i).getName());
        Log.d("Adapter", "setting coin : + "  + coins.get(i).getSymbol());
    }

    @Override
    public int getItemCount() {
        return coins.size();
    }

    public void setCoinList(List<Coin> coins) {
        this.coins = coins;
    }
}
