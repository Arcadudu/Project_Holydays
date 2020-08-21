package ru.arcadudu.project_holydays;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import java.nio.channels.InterruptedByTimeoutException;
import java.util.Objects;


public class MainActivity3_Filtered extends AppCompatActivity {

    private static final String FILTER = "filter";

    private static final String TITLE = "title";

    private static final String RESOURCE = "resource";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3_filtered);


        String chosenCategoryIcon = getIntent().getStringExtra(MainActivity2.CATEGORY);
        Log.e("AA", ">> " + chosenCategoryIcon);

        // Иконка перехода на карту
        ImageView map = findViewById(R.id.iv_settings);
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("geo:45.044840,38.976030"));
                startActivity(intent);
            }
        });


        // Иконка активной категории
        final ImageView icon_main3_active = findViewById(R.id.icon_main3_active);
        icon_main3_active.setImageResource(ResourceHelper.getIcon(chosenCategoryIcon != null ? chosenCategoryIcon : ""));
        icon_main3_active.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ourBackPressed();
            }
        });

        // Подпись активной категории
        TextView tv_main3_active = findViewById(R.id.tv_main3_active);
        tv_main3_active.setText(getIntent().getStringExtra(TITLE));

        // Выбранный фильтр
        Animation filterAnimation = AnimationUtils.loadAnimation(this, R.anim.lefttoright_plus_fade_in);
        TextView tv_chosen_filter = findViewById(R.id.tv_chosen_filter);
        tv_chosen_filter.setText(getIntent().getStringExtra(FILTER));
        tv_chosen_filter.setBackground(getResources().getDrawable(R.drawable.style_carousel_icon_pushed));
        tv_chosen_filter.setTextColor(getResources().getColor(R.color.white));
        tv_chosen_filter.startAnimation(filterAnimation);

        // Кнопка закрытия фильтра
        ImageView iv_close_button = findViewById(R.id.iv_close_button);
        iv_close_button.startAnimation(filterAnimation);
        iv_close_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ourBackPressed();
            }
        });


    }

    private void ourBackPressed() {
        //                Intent intent = new Intent(MainActivity3_Filtered.this, MainActivity2.class);
//                startActivity(intent);
//                overridePendingTransition(0, 0);
        MainActivity3_Filtered.super.onBackPressed();
        overridePendingTransition(0, 0);
    }

    @Override
    public void onBackPressed() {

    }
}