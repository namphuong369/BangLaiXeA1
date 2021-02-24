package com.nam.banglaixea1.Activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.nam.banglaixea1.Adapter.ListAdapter;
import com.nam.banglaixea1.Adapter.QuestionAdapter;
import com.nam.banglaixea1.Module.Category;

import com.nam.banglaixea1.Module.Question;
import com.nam.banglaixea1.R;
import com.nam.banglaixea1.SQLite.QuesDbHelper;

import java.util.List;

import static maes.tech.intentanim.CustomIntent.customType;

public class QuestionActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewPager viewPager;
    private TextView tv_ques_cout;
    private TextView tv_ques_count_timer;
    private ImageView next, back;
    private View view_timer;
    private List<Question> list;
    private QuestionAdapter adapter;
    private QuesDbHelper dbHelper;
    private int data;
    private String name = "";
    private ListAdapter listAdapter;
    private int count=0;

    private TextView title,end;
    private ImageView iv_back,reset;

    private List<Category> categoryList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        dbHelper = QuesDbHelper.getInstance(this);
        data = getIntent().getExtras().getInt("DATA");
        if (data == 0) {
            name = "Khái niệm và quy tắc";
        } else if (data == 3) {
            name = "Kỹ thuật lái xe";
        } else if (data == 2) {
            name = "Câu hỏi điểm liệt";
        } else if (data == 1) {
            name = "Văn hóa và đạo đức lái xe";
        }else if(data==4){
            name="Biển báo đường bộ";
        }else if(data==5){
            name="Sa hình";
        }
        list = dbHelper.getQuestions(data + 1);
        initView();
        showData();

    }

    private void initView() {
        tv_ques_cout = findViewById(R.id.tv_pos);
        viewPager = findViewById(R.id.view_pager);
        back = findViewById(R.id.iv_back);
        next = findViewById(R.id.iv_next);
        tv_ques_count_timer=findViewById(R.id.tv_count_timer);
        view_timer=findViewById(R.id.view_count_timer);
        view_timer.setVisibility(View.GONE);
        tv_ques_count_timer.setVisibility(View.GONE);

        title=findViewById(R.id.tv_title);
        end=findViewById(R.id.tv_end_toolbar);
        iv_back=findViewById(R.id.iv_back_toolbar);
        reset=findViewById(R.id.iv_add_toolbar);
        title.setText(name);
        end.setVisibility(View.GONE);
        reset.setImageResource(R.drawable.ic_menu);
        //------
        iv_back.setOnClickListener(this);
        reset.setOnClickListener(this);
        //------
        categoryList = dbHelper.getCategory();
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
                tv_ques_cout.setText("" + "Câu " + (viewPager.getCurrentItem() + 1) + " / " + list.size());
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
        final Dialog dialog = new Dialog(QuestionActivity.this);
        dialog.setContentView(R.layout.dialog_list);
        dialog.setCanceledOnTouchOutside(false);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        TextView name_list = dialog.findViewById(R.id.tv_name_list);
        Button bt_list = dialog.findViewById(R.id.bt_close_list);
        RecyclerView recyclerView = dialog.findViewById(R.id.recycler_list);
        //
        name_list.setText(name);
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
    protected void onStop() {
        super.onStop();
        dbHelper.close();
    }
    private void countAnswer(){
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getYour_answer() != -1) {
                count++;
            }
        }
        dbHelper.updateCountQues(String.valueOf(data + 1), new Category(count));
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        countAnswer();
        startActivity(new Intent(QuestionActivity.this,StartActivity.class));
        customType(QuestionActivity.this, "right-to-left");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_back_toolbar:
                countAnswer();
                startActivity(new Intent(QuestionActivity.this,StartActivity.class));
                customType(QuestionActivity.this, "right-to-left");
                break;
            case R.id.iv_add_toolbar:
                showListDialog();
                break;

        }
    }
}