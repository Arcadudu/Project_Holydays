package ru.arcadudu.project_holydays;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class Settings_Activity extends AppCompatActivity {

    Spinner cities;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        // Спиннер
        cities = findViewById(R.id.spinner_cities);
        ArrayAdapter<CharSequence> adapter =
                new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, getResources().getTextArray(R.array.city));
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        cities.setAdapter(adapter);


        View back = findViewById(R.id.iv_btn_back_to_main);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        View forward = findViewById(R.id.iv_btn_forward_to_login);
        forward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Settings_Activity.this, ProfileLoginActivity.class);
                startActivity(intent);
            }
        });


    }

}