package ru.arcadudu.project_holydays;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import ru.arcadudu.project_holydays.fragments.PageFragment1;
import ru.arcadudu.project_holydays.fragments.PageFragment2;
import ru.arcadudu.project_holydays.fragments.PageFragment3;

public class ViewPagerActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private PagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);

        List<Fragment> list =new ArrayList<>();
        list.add(new PageFragment1());
        list.add(new PageFragment2());
        list.add(new PageFragment3());


        viewPager = findViewById(R.id.view_pager);
        pagerAdapter = new PagerAdapter(getSupportFragmentManager(), list);
        viewPager.setAdapter(pagerAdapter);
    }
}