package com.cmejia.adoptame.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.cmejia.adoptame.R;
import com.cmejia.adoptame.adapters.ViewPagerAdapter;
import com.cmejia.adoptame.fragments.DetailsFragment;
import com.cmejia.adoptame.fragments.MapFragment;
import com.google.android.material.tabs.TabLayout;

public class TabsActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabs);

        viewPager = findViewById(R.id.view_pager);
        tabLayout = findViewById(R.id.tab_layout);

        setupViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager, true);
    }


    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        // getChildFragmentManager() usar cuando se tiene un fragment dentro de otro fragment
        // getSupportFragmentManager() usar cuando tengo un fragment dentro de una activity

        adapter.addFragment(new DetailsFragment(), "DETALLES");
        adapter.addFragment(new MapFragment(), "MAPA");

        viewPager.setAdapter(adapter);
    }
}
