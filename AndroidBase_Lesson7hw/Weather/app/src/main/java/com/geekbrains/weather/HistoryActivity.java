package com.geekbrains.weather;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class HistoryActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.history_layout);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        HistoryAdapter historyAdapter = new HistoryAdapter(this);
        recyclerView.setAdapter(historyAdapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
    }
}
