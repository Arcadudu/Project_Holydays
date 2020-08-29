package ru.arcadudu.project_holydays;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    CategoryAdapter adapter;
    RecyclerView recyclerView;
    ImageView iv_settings; // Иконка настроек

    // Массив иконок категорий
    private int[] images = {
            R.drawable.icon_food, R.drawable.icon_entertainment,
            R.drawable.icon_beauty, R.drawable.icon_health, R.drawable.icon_auto,
            R.drawable.icon_sports, R.drawable.icon_souvenir, R.drawable.icon_education
    };

    final String LOG_ENTRY = "TO SETTINGS";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Массив названий категорий
        String[] categories = getResources().getStringArray(R.array.categories);

        // Adapter
        adapter = new CategoryAdapter(this, categories, images);

        // RecyclerView logic
        recyclerView = findViewById(R.id.recycler_view_categories);
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        // Поле ввода "Поиск в г. Краснодар"
        EditText et_search = findViewById(R.id.et_search_in_KRD);


        // Кнопка "настройки"
        iv_settings = findViewById(R.id.iv_settings);
        Animation settingsOn = AnimationUtils.loadAnimation(this, R.anim.rotate_scalein_fadein);
        iv_settings.startAnimation(settingsOn);
        iv_settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.button_rotate_animation);
                iv_settings.startAnimation(animation);
                final Intent intent = new Intent(MainActivity.this, Settings_Activity.class);

                iv_settings.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(intent);
                    }
                }, 500);

            }
        });


    }


}