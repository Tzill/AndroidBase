package com.geekbrains.weather;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.ViewHolder> {
    private String[] historyTemperature;
    private Context context;

    public HistoryAdapter(Context context) {
        this.context = context;
        this.historyTemperature = context.getResources().getStringArray(R.array.history_array);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = (TextView)itemView.findViewById(R.id.history_tv);
        }
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.history_single_item, parent, false);
        HistoryAdapter.ViewHolder viewHolder = new HistoryAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.textView.setText(historyTemperature[position]);

    }

    @Override
    public int getItemCount() {
        return historyTemperature.length;
    }


}
