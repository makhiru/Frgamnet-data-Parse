package com.example.fragmentdataparse;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity implements A_Fragment.FragmnetAListner,B_Fragment.FragmnetBListner {

    TabLayout tabLayout;
    ViewPager viewpager;
    Adapter_Viewpager adapter;
    A_Fragment a_fragment;
    B_Fragment b_fragment;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.tablayout);
        viewpager = findViewById(R.id.viewpager);

        adapter = new Adapter_Viewpager(getSupportFragmentManager());
        adapter.addfragment(new A_Fragment(), " Fragment A");
        adapter.addfragment(new B_Fragment(), "Fragment B");

        viewpager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewpager);

        a_fragment = new A_Fragment();
        b_fragment = new B_Fragment();

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.viewpager, a_fragment)
                .replace(R.id.viewpager, b_fragment)
                .commit();
    }


    @Override
    public void onInputBsent(CharSequence input) {
        a_fragment.updateEdittext(input);
    }

    @Override
    public void onInputAsent(CharSequence input) {
        b_fragment.updateEdittext(input);
    }
}