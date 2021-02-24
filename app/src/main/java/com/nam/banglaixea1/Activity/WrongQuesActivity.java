package com.nam.banglaixea1.Activity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.nam.banglaixea1.Adapter.ListAdapter;
import com.nam.banglaixea1.Adapter.QuestionAdapter;
import com.nam.banglaixea1.Module.Question;
import com.nam.banglaixea1.R;


import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import static maes.tech.intentanim.CustomIntent.customType;

public class WrongQuesActivity extends AppCompatActivity implements View.OnClickListener{
    private ViewPager viewPager;
    private TextView tv_ques_count;
    private ImageView next, back;
    private TextView tv_ques_count_timer;
    private View view_timer;
    private List<Question> list = new ArrayList<>();
    private QuestionAdapter adapter;
    private ListAdapter listAdapter;
    private String questionList;



    private TextView title,end;
    private ImageView iv_back,reset;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        initView();
        questionList=getIntent().getStringExtra("LIST");
        Gson gson=new Gson();
        Type type=new TypeToken<List<Question>>(){}.getType();
        list=gson.fromJson(questionList,type);
        showData();
    }

    private void initView() {
        title=findViewById(R.id.tv_title);
        end=findViewById(R.id.tv_end_toolbar);
        iv_back=findViewById(R.id.iv_back_toolbar);
        reset=findViewById(R.id.iv_add_toolbar);
        title.setText("Các câu sai");
        end.setVisibility(View.GONE);
        reset.setImageResource(R.drawable.ic_menu);
        //------
        iv_back.setOnClickListener(this);
        reset.setOnClickListener(this);
        //------
        tv_ques_count = findViewById(R.id.tv_pos);
        viewPager = findViewById(R.id.view_pager);
        back = findViewById(R.id.iv_back);
        next = findViewById(R.id.iv_next);
        tv_ques_count_timer=findViewById(R.id.tv_count_timer);
        view_timer=findViewById(R.id.view_count_timer);
        view_timer.setVisibility(View.GONE);
        tv_ques_count_timer.setVisibility(View.GONE);
    }

    private void showData() {
        adapter = new QuestionAdapter(list, getApplicationContext());
        viewPager.setAdapter(adapter);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
            }
        });

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                tv_ques_count.setText("" + "Câu " + (viewPager.getCurrentItem() + 1) + " / " + list.size());
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }


    private void showListDialog() {
        final Dialog dialog = new Dialog(WrongQuesActivity.this);
        dialog.setContentView(R.layout.dialog_list);
        dialog.setCanceledOnTouchOutside(false);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        TextView name_list = dialog.findViewById(R.id.tv_name_list);
        Button bt_list = dialog.findViewById(R.id.bt_close_list);
        RecyclerView recyclerView = dialog.findViewById(R.id.recycler_list);
        //
        name_list.setText("CÁC CÂU SAI");
        //
        GridLayoutManager layoutManager = new GridLayoutManager(getApplicationContext(), 5);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setNestedScrollingEnabled(false);
        listAdapter = new ListAdapter(list, getApplicationContext());
        recyclerView.setAdapter(listAdapter);
        listAdapter.setItemClickListener(new ListAdapter.ClickListener() {
            @Override
            public void onItemClick(int position, View v) {
                viewPager.setCurrentItem(position);
                dialog.dismiss();
            }
        });
        //
        bt_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_back_toolbar:
                startActivity(new Intent(WrongQuesActivity.this,MainActivity.class));
                customType(WrongQuesActivity.this, "right-to-left");
                break;
            case R.id.iv_add_toolbar:
                showListDialog();
                break;

        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(WrongQuesActivity.this,MainActivity.class));
        customType(WrongQuesActivity.this, "right-to-left");
    }
}
