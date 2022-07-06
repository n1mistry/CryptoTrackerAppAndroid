package com.example.cryptotrackerapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class CurrencyRVAdapter extends RecyclerView.Adapter<CurrencyRVAdapter.ViewHolder> {
    private ArrayList<CurrencyRVModel> currencyRVModelArrayList;
    private Context context;
    private static DecimalFormat df2 = new DecimalFormat("#.##");

    public CurrencyRVAdapter(ArrayList<CurrencyRVModel> currencyRVModelArrayList, Context context) {
        this.currencyRVModelArrayList = currencyRVModelArrayList;
        this.context = context;
    }

    public void filterList(ArrayList<CurrencyRVModel> filteredList) {
        currencyRVModelArrayList = filteredList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CurrencyRVAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.currency_rv_item,parent,false);
        return new CurrencyRVAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CurrencyRVAdapter.ViewHolder holder, int position) {
        CurrencyRVModel currencyRVModel = currencyRVModelArrayList.get(position);
        holder.currencyNameTV.setText(currencyRVModel.getName());
        holder.symbolTV.setText(currencyRVModel.getSymbol());
        holder.rateTV.setText("$ " + df2.format(currencyRVModel.getPrice()));
        holder.RLCurrency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, CryptoActivity.class);
                intent.putExtra("coinName", currencyRVModel.getName());
                intent.putExtra("coinSymbol", currencyRVModel.getSymbol());
                intent.putExtra("coinPrice", "$ " + df2.format(currencyRVModel.getPrice()));
                intent.putExtra("coinMaxSupply", currencyRVModel.getMaxSupply());
                intent.putExtra("coinCirculatingSupply", currencyRVModel.getCirculatingSupply());
                intent.putExtra("coinTotalSupply", currencyRVModel.getTotalSupply());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return currencyRVModelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView currencyNameTV,symbolTV,rateTV;
        private RelativeLayout RLCurrency;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            currencyNameTV = itemView.findViewById(R.id.idTVCurrencyName);
            symbolTV = itemView.findViewById(R.id.idTVSymbol);
            rateTV = itemView.findViewById(R.id.idTVCurrencyRate);
            RLCurrency = itemView.findViewById(R.id.idRLCurrency);
        }
    }
}
