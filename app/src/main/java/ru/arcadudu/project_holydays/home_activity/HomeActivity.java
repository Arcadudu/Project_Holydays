package ru.arcadudu.project_holydays.home_activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import ru.arcadudu.project_holydays.R;
import ru.arcadudu.project_holydays.Settings_Activity;
import ru.arcadudu.project_holydays.home_activity.utils.CategoryAdapter;
import ru.arcadudu.project_holydays.home_activity.utils.FeedItem;
import ru.arcadudu.project_holydays.home_activity.utils.FeedItemAdapter;
import ru.arcadudu.project_holydays.home_activity.utils.Nearby;
import ru.arcadudu.project_holydays.home_activity.utils.NearbyAdapter;

public class HomeActivity extends AppCompatActivity {

    // vars
    CategoryAdapter categoryAdapter;
    NearbyAdapter nearbyAdapter;
    FeedItemAdapter feedItemAdapter;

    RecyclerView categoryRecycler, nearbyRecycler, feedRecycler;

    ImageView iv_settings;

    private int[] category_images = {
            R.drawable.icon_food, R.drawable.icon_entertainment,
            R.drawable.icon_beauty, R.drawable.icon_health, R.drawable.icon_auto,
            R.drawable.icon_sports, R.drawable.icon_souvenir, R.drawable.icon_education
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        setCategories();
        setNearby();


        //// Feed :

        List<FeedItem> feedItemList = new ArrayList<>();
        feedItemList.add(new FeedItem
                (R.drawable.item1_nike_sneakers, getResources().getString(R.string.feed_item1_discount), "7500₽", "3375₽", getResources().getString(R.string.feed_item1_name)));
        feedItemList.add
                (new FeedItem(R.drawable.item2_geekbrain_course, getResources().getString(R.string.feed_item2_discount), "45000₽", "27000₽", getResources().getString(R.string.feed_item2_name)));
        feedItemList.add
                (new FeedItem(R.drawable.item3_zero_vape_device, getResources().getString(R.string.feed_item3_discount), "1600₽", "1280₽", getResources().getString(R.string.feed_item3_name)));
        feedItemList.add
                (new FeedItem(R.drawable.item4_chocolate_deck_cropped, getResources().getString(R.string.feed_item4_discount), "5200₽", "4420₽", getResources().getString(R.string.feed_item4_name)));
        // Adapter
        feedItemAdapter = new FeedItemAdapter(feedItemList);

        // Feed RecyclerView set
        feedRecycler = findViewById(R.id.recycler_view_feed);
        feedRecycler.setHasFixedSize(true);
        feedRecycler.setAdapter(feedItemAdapter);
        feedRecycler.setLayoutManager(new LinearLayoutManager(this));

        // SearchBar
        EditText et_search = findViewById(R.id.et_search_in_KRD);


        // Settings icon
        iv_settings = findViewById(R.id.iv_settings);
//        iv_settings.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(HomeActivity.this, ViewPagerActivity.class);
//                startActivity(intent);
//            }
//        });
        iv_settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animation = AnimationUtils.loadAnimation(HomeActivity.this, R.anim.button_rotate_animation);
                iv_settings.startAnimation(animation);
                final Intent intent = new Intent(HomeActivity.this, Settings_Activity.class);

                iv_settings.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(intent);
                    }
                }, 500);

            }
        });


    }

    private void setNearby() {
        //// Nearby :

        List<Nearby> nearbyList = new ArrayList<>();
        nearbyList.add(new Nearby(R.drawable.dodo_pizza, getResources().getString(R.string.suggestion1_text)));
        nearbyList.add(new Nearby(R.drawable.lada_xcode, getResources().getString(R.string.suggestion2_text)));
        nearbyList.add(new Nearby(R.drawable.clinic, getResources().getString(R.string.suggestion3_text)));
        nearbyList.add(new Nearby(R.drawable.bicycle_merida, getResources().getString(R.string.suggestion4_text)));

        // Adapter
        nearbyAdapter = new NearbyAdapter(nearbyList);

        // Nearby RecyclerView set
        nearbyRecycler = findViewById(R.id.recycler_view_nearby_suggest);
        nearbyRecycler.setHasFixedSize(true);
        nearbyRecycler.setAdapter(nearbyAdapter);
        nearbyRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
    }

    private void setCategories() {
        //// Categories :

        String[] category_titles = getResources().getStringArray(R.array.categories);

        // Adapter
        categoryAdapter = new CategoryAdapter(this, category_titles, category_images);

        // Category RecyclerView set
        categoryRecycler = findViewById(R.id.recycler_view_categories);
        categoryRecycler.setAdapter(categoryAdapter);
        categoryRecycler.setHasFixedSize(true);
        categoryRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
    }


}