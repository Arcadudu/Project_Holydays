package ru.arcadudu.project_holydays;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SearchView;

public class ProfileLoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_login);

        // Кнопка возврата на предыдущий экран
        View back = findViewById(R.id.iv_btn_back_to_settings);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        // Кнопка "пройти регистрацию"
        Button registration = findViewById(R.id.btn_registration);
        registration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProfileLoginActivity.this, RegistrationActivity.class);
                startActivity(intent);
            }
        });
    }
}