package com.example.cryptotrackerapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TweetsRecAdapter extends RecyclerView.Adapter<TweetsRecAdapter.ViewHolder> {
    private ArrayList<TweetsRecModel> tweetsArrayList;
    private Context context;
    public TweetsRecAdapter(ArrayList<TweetsRecModel> tweetsArrayList, Context context) {
        this.tweetsArrayList = tweetsArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.tweets_item,parent,false);
        return new TweetsRecAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TweetsRecAdapter.ViewHolder holder, int position) {
        TweetsRecModel tweetsRecModel = tweetsArrayList.get(position);
        holder.tweetName.setText(tweetsRecModel.getName());
        holder.tweetTweet.setText(tweetsRecModel.getTweet());
    }

    @Override
    public int getItemCount() {
        return tweetsArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tweetName, tweetTweet;
        private RelativeLayout tweets_item;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tweetName = itemView.findViewById(R.id.tweets_name);
            tweetTweet = itemView.findViewById(R.id.tweets_tweet);
            tweets_item = itemView.findViewById(R.id.tweets_item);
        }
    }
}
