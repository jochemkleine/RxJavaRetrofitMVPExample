package kleine.com.reqtrader.priceListing;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import kleine.com.reqtrader.R;

public class PriceListViewholder extends RecyclerView.ViewHolder {

    TextView symbol, name;

    public PriceListViewholder(@NonNull View itemView) {
        super(itemView);
        symbol = itemView.findViewById(R.id.coinSymbol);
        name = itemView.findViewById(R.id.coinName);


    }
}
