package ru.arcadudu.project_holydays;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    ImageView iv_settings; // настройки

    final String LOG_ENTRY = "TO SETTINGS";

    // Экстра для интента
    private static final String CATEGORY = "category_icon";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

        // Карусель, иконки:
        ImageView icon_food = findViewById(R.id.icon_food);
        ImageView icon_beauty = findViewById(R.id.icon_beauty);
        ImageView icon_health = findViewById(R.id.icon_health);
        ImageView icon_sports = findViewById(R.id.icon_sports);
        ImageView icon_souvenir = findViewById(R.id.icon_souvenir);
        ImageView icon_education = findViewById(R.id.icon_education);
        ImageView icon_automobile = findViewById(R.id.icon_automobile);
        ImageView icon_entertainment = findViewById(R.id.icon_entertainment);

        // Стартовая анимация карусели иконок:
        final Animation startAnimation = AnimationUtils.loadAnimation(this, R.anim.fadein);
        icon_food.startAnimation(startAnimation);
        icon_beauty.startAnimation(startAnimation);
        icon_health.startAnimation(startAnimation);
        icon_sports.startAnimation(startAnimation);
        icon_souvenir.startAnimation(startAnimation);
        icon_education.startAnimation(startAnimation);
        icon_automobile.startAnimation(startAnimation);
        icon_entertainment.startAnimation(startAnimation);

        // Слушатели на иконках:
        icon_food.setOnClickListener(this);
        icon_beauty.setOnClickListener(this);
        icon_health.setOnClickListener(this);
        icon_sports.setOnClickListener(this);
        icon_souvenir.setOnClickListener(this);
        icon_education.setOnClickListener(this);
        icon_automobile.setOnClickListener(this);
        icon_entertainment.setOnClickListener(this);
    }


    // Нажатие на иконки карусели = переход на активити категорий
    @Override
    public void onClick(View view) {
        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
        switch (view.getId()) {
            case R.id.icon_food:
                intent.putExtra(CATEGORY, "Food");
                break;
            case R.id.icon_beauty:
                intent.putExtra(CATEGORY, "Beauty");
                break;
            case R.id.icon_health:
                intent.putExtra(CATEGORY, "Health");
                break;
            case R.id.icon_sports:
                intent.putExtra(CATEGORY, "Sports");
                break;
            case R.id.icon_souvenir:
                intent.putExtra(CATEGORY, "Souvenir");
                break;
            case R.id.icon_education:
                intent.putExtra(CATEGORY, "Education");
                break;
            case R.id.icon_automobile:
                intent.putExtra(CATEGORY, "Automobile");
                break;
            case R.id.icon_entertainment:
                intent.putExtra(CATEGORY, "Entertainment");
                break;
        }
        startActivity(intent);
        overridePendingTransition(0, 0);
    }


}