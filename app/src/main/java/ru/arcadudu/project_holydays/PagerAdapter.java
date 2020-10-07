package ru.arcadudu.project_holydays;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.List;

public class PagerAdapter extends FragmentStatePagerAdapter {

    private List<Fragment> fragmentList;

    public PagerAdapter(FragmentManager fragmentManager, List<Fragment> list){
        super(fragmentManager);
        this.fragmentList = list;

    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }
}
