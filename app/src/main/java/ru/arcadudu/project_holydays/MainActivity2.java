package ru.arcadudu.project_holydays;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener {


    public final static String CATEGORY = "category_icon";
    private final static String FILTER = "filter";
    private final static String TITLE = "title";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        // Иконка настроек:
        ImageView ivSettingsToMap = findViewById(R.id.iv_settings_to_map);
        ivSettingsToMap.setImageResource(R.drawable.icon_to_map);

        Animation toMap = AnimationUtils.loadAnimation(this, R.anim.rotate_scalein_fadein);
        ivSettingsToMap.startAnimation(toMap);

        ivSettingsToMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity2.this, MapActivity_main.class);
                startActivity(intent);

//                Intent intent = new Intent(Intent.ACTION_VIEW);
//                intent.setData(Uri.parse("geo:45.044840,38.976030"));
//                startActivity(intent);
            }
        });


        // Активная иконка карусели + название категории
        final ImageView icon_main2_active = findViewById(R.id.icon_main2_active);
        final TextView tv_main2_active = findViewById(R.id.tv_main2_active);

        // Анимация появления активной категории (иконка + название категории)
        Animation iconAndTextAnimation = AnimationUtils.loadAnimation(this, R.anim.lefttoright_plus_fade_in);
        icon_main2_active.startAnimation(iconAndTextAnimation);
        tv_main2_active.startAnimation(iconAndTextAnimation);

        // Выход на предыдущий экран по нажатии на активную категорию
        icon_main2_active.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity2.this, MainActivity.class);
                startActivity(intent);
                overridePendingTransition(0, 0);
            }
        });


        // Список с текстом для строк подкатегорий
        // (пока заточен исключительно под 6 строк.....)
        List<String> filters = new ArrayList<>();


        // Определение категории
        String chosenCategoryIcon = getIntent().getStringExtra(CATEGORY);

        assert chosenCategoryIcon != null;

        icon_main2_active.setImageResource(ResourceHelper.getIcon(chosenCategoryIcon));
        switch (chosenCategoryIcon) {
            case "Food":
                tv_main2_active.setText(getResources().getString(R.string.Food));
                filters = Arrays.asList(getResources().getStringArray(R.array.FoodSubCategories));
                break;
            case "Entertainment":
                tv_main2_active.setText(getResources().getString(R.string.Entertainment));
                filters = Arrays.asList(getResources().getStringArray(R.array.EntertainmentSubCategories));
                break;
            case "Beauty":
                tv_main2_active.setText(getResources().getString(R.string.Beauty));
                filters = Arrays.asList(getResources().getStringArray(R.array.BeautySubCategories));
                break;
            case "Health":
                tv_main2_active.setText(getResources().getString(R.string.Health));
                filters = Arrays.asList(getResources().getStringArray(R.array.HealthSubCategories));
                break;
            case "Automobile":
                tv_main2_active.setText(getResources().getString(R.string.Automobile));
                filters = Arrays.asList(getResources().getStringArray(R.array.AutomobileSubCategories));
                break;
            case "Sports":
                tv_main2_active.setText(getResources().getString(R.string.Sports));
                filters = Arrays.asList(getResources().getStringArray(R.array.SportsSubCategories));
                break;
            case "Souvenir":
                tv_main2_active.setText(getResources().getString(R.string.Souvenir));
                filters = Arrays.asList(getResources().getStringArray(R.array.SouvenirSubCategories));
                break;
            case "Education":
                tv_main2_active.setText(getResources().getString(R.string.Education));
                filters = Arrays.asList(getResources().getStringArray(R.array.EducationSubCategories));
                break;

        }


        /// Неполучившиеся циклы прохода по дочерним элементам ViewGroup:

//        ViewGroup tagFilterGroup1 = findViewById(R.id.ll_categories_vgroup1);
//        for (int index = 0; index < ((ViewGroup) tagFilterGroup1).getChildCount(); index++) {
//            TextView nextChild = (TextView) ((ViewGroup) tagFilterGroup1).getChildAt(index);
//            nextChild.setText(filters.get(index));
//            filters.remove(index);
//        }
//
//        ViewGroup tagFilterGroup2 = findViewById(R.id.ll_categories_vgroup2);
//        for (int index = 0; index < ((ViewGroup) tagFilterGroup1).getChildCount(); index++) {
//            TextView nextChild = (TextView) ((ViewGroup) tagFilterGroup1).getChildAt(index);
//            nextChild.setText(filters.get(index));
//            filters.remove(index);
//        }


        // Группа подкатегорий
        TextView tv_category_filter1 = findViewById(R.id.tv_category_filter1);
        TextView tv_category_filter2 = findViewById(R.id.tv_category_filter2);
        TextView tv_category_filter3 = findViewById(R.id.tv_category_filter3);
        TextView tv_category_filter4 = findViewById(R.id.tv_category_filter4);
        TextView tv_category_filter5 = findViewById(R.id.tv_category_filter5);
        TextView tv_category_filter6 = findViewById(R.id.tv_category_filter6);

        // Анимация появления "фильтров"
        Animation categoryFilterAnimation = AnimationUtils.loadAnimation(this, R.anim.lefttoright_plus_fade_in);

        tv_category_filter1.startAnimation(categoryFilterAnimation);
        tv_category_filter2.startAnimation(categoryFilterAnimation);
        tv_category_filter3.startAnimation(categoryFilterAnimation);
        tv_category_filter4.startAnimation(categoryFilterAnimation);
        tv_category_filter5.startAnimation(categoryFilterAnimation);
        tv_category_filter6.startAnimation(categoryFilterAnimation);

        // Список для дальнейшего именования "фильтров"
        List<TextView> group = new ArrayList<>();
        group.add(tv_category_filter1);
        group.add(tv_category_filter2);
        group.add(tv_category_filter3);
        group.add(tv_category_filter4);
        group.add(tv_category_filter5);
        group.add(tv_category_filter6);

        // Назначаем текста для "фильтров" подкатегорий
        for (int i = 0; i < group.size(); i++) {
            TextView tv = group.get(i);
            if (!filters.get(i).isEmpty()) {
                tv.setText(filters.get(i));
                tv.setBackground(getResources().getDrawable(R.drawable.style_carousel_icon_active));
            } else {
                tv.setVisibility(View.INVISIBLE);
            }
        }

        // Вешаем слушатели на "фильтры"
        tv_category_filter1.setOnClickListener(this);
        tv_category_filter2.setOnClickListener(this);
        tv_category_filter3.setOnClickListener(this);
        tv_category_filter4.setOnClickListener(this);
        tv_category_filter5.setOnClickListener(this);
        tv_category_filter6.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if (view.getVisibility() != View.INVISIBLE) {
            Intent intent = new Intent(MainActivity2.this, MainActivity3_Filtered.class);

            // Выбранный фильтр:
            TextView tv_filter = (TextView) view;
            String filter = tv_filter.getText().toString();
            intent.putExtra(FILTER, filter);

            // Подпись категории:
            TextView tv_category_title = findViewById(R.id.tv_main2_active);
            String titleText = tv_category_title.getText().toString();
            intent.putExtra(TITLE, titleText);

            // Иконка категории:
            ImageView imageView = findViewById(R.id.icon_main2_active);
            Log.e("AA", "> " + getIntent().getStringExtra(CATEGORY));
            intent.putExtra(CATEGORY, getIntent().getStringExtra(CATEGORY));

            // TODO: 10.08.2020 получить айдишник соответствующей иконки для передачи на след. экран

            startActivity(intent);
            overridePendingTransition(0, 0);
        }

    }
}