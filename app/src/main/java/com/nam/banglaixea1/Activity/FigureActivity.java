package com.nam.banglaixea1.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;
import com.nam.banglaixea1.Adapter.TabFigureAdapter;
import com.nam.banglaixea1.R;

import static maes.tech.intentanim.CustomIntent.customType;


public class FigureActivity extends AppCompatActivity implements View.OnClickListener{
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private TextView title,end;
    private ImageView iv_back,reset;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_figure);
        initView();

    }

    private void initView() {
        title=findViewById(R.id.tv_title);
        end=findViewById(R.id.tv_end_toolbar);
        iv_back=findViewById(R.id.iv_back_toolbar);
        reset=findViewById(R.id.iv_add_toolbar);
        title.setText("Biển báo đường bộ");
        end.setVisibility(View.GONE);
        reset.setVisibility(View.GONE);
        iv_back.setOnClickListener(this);

        viewPager=findViewById(R.id.view_group);
        tabLayout=findViewById(R.id.tab_layout);
        viewPager.setAdapter(new TabFigureAdapter(getSupportFragmentManager()));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tabLayout.getSelectedTabPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_back_toolbar:
                startActivity(new Intent(FigureActivity.this,MainActivity.class));
                customType(FigureActivity.this, "right-to-left");
                break;
        }
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(FigureActivity.this,MainActivity.class));
        customType(FigureActivity.this, "right-to-left");
    }
}