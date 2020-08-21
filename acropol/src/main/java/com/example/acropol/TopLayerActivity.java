package com.example.acropol;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class TopLayerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_layer);

        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                if(position==0){
                    Intent intent = new Intent(TopLayerActivity.this, RestaurantActivity.class);
                    startActivity(intent);
                }
            }
        };

        ListView listView = findViewById(R.id.lv_list);
        listView.setOnItemClickListener(itemClickListener);

    }
}
