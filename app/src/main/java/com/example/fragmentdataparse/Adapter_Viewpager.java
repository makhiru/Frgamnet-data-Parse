package com.example.fragmentdataparse;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class Adapter_Viewpager extends FragmentPagerAdapter {

    List<Fragment> arrfrag = new ArrayList<>();
    List<String> arrstring = new ArrayList<>();

    public Adapter_Viewpager(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return arrfrag.get(position);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return arrstring.get(position);
    }

    @Override
    public int getCount() {
        return arrfrag.size();
    }

    public void addfragment(Fragment fragment, String title) {
        arrfrag.add(fragment);
        arrstring.add(title);
    }
}
