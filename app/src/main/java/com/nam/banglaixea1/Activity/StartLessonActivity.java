package com.nam.banglaixea1.Activity;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.nam.banglaixea1.Adapter.ListAdapter;
import com.nam.banglaixea1.Adapter.ListCheckQuesAdapter;
import com.nam.banglaixea1.Adapter.QuestionAdapter;
import com.nam.banglaixea1.Adapter.StartLessonAdapter;
import com.nam.banglaixea1.Module.CustomToast;
import com.nam.banglaixea1.Module.Lesson;
import com.nam.banglaixea1.Module.Question;
import com.nam.banglaixea1.R;
import com.nam.banglaixea1.SQLite.LessonDbHelper;
import com.nam.banglaixea1.SQLite.QuesDbHelper;

import java.util.List;
import java.util.Locale;

import static maes.tech.intentanim.CustomIntent.customType;


public class StartLessonActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String EXTRA_LESSON="extra_lesson";
    private final long COUNTDOWN_IN_MILLIS = 1141000;
    private ViewPager viewPager;
    private TextView tv_ques_count;
    private TextView tv_ques_count_timer;
    private ImageView next, back;


    private int data = 0;
    private int count = 0;
    private Question question;
    private LessonDbHelper lessonDbHelper;
    private List<Question> questionList;
    private StartLessonAdapter adapter;
    private ListCheckQuesAdapter listCheckQuesAdapter;

    private CountDownTimer countDownTimer;
    private long time_left;
    private long backPressedTime;
    private int minutes;
    private int seconds;

    private TextView title, end;
    private ImageView iv_back, reset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        data = getIntent().getExtras().getInt("DATA");
        initView();

        lessonDbHelper = LessonDbHelper.getInstance(getApplicationContext());
        questionList = lessonDbHelper.getQuestions(data);
        showData();
        time_left = COUNTDOWN_IN_MILLIS;
        startCountDown();
    }

    private void showData() {
        adapter = new StartLessonAdapter(questionList, getApplicationContext());
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
            @SuppressLint("SetTextI18n")
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                tv_ques_count.setText("" + "Câu " + (viewPager.getCurrentItem() + 1) + " / " + questionList.size());
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void startCountDown() {
        countDownTimer = new CountDownTimer(time_left, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                time_left = millisUntilFinished;
                updateCountDown();
            }

            @Override
            public void onFinish() {
                time_left = 0;
                updateCountDown();
            }
        }.start();
    }

    private void updateCountDown() {
        minutes = (int) (time_left / 1000) / 60;
        seconds = (int) (time_left / 1000) % 60;
        String timeFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);
        tv_ques_count_timer.setText(timeFormatted);

    }

    private void finishLesson() {
        checkAnswer();
        startActivity(new Intent(this,LessonActivity.class));
        customType(StartLessonActivity.this, "right-to-left");
    }

    private void checkAnswer() {
        int check = 0;
        boolean state = false;
        int state_warning = 0;

        int number_wrong = 0;
        int number_null_answer = 0;
        int number_warning = 0;
        for (int i = 0; i < questionList.size(); i++) {
            question = questionList.get(i);
            if (question.getYour_answer() == question.getAnswer()) {
                count++;
            }

            if(question.getWarning()==1){
                if(question.getYour_answer() != question.getAnswer()){
                    state=true;
                    number_warning++;
                }
            }
            if(question.getYour_answer() != question.getAnswer()){
                number_wrong++;
            }
            if(question.getYour_answer()==-1){
                number_null_answer++;
            }

        }
        if (count >= 21 && state == false) {
            check = 1;
            state_warning = 0;
        } else if (count >= 21 && state) {
            check = 0;
            state_warning = 1;
        } else if (count < 21 && state == false) {
            check = 0;
            state_warning = 0;
        } else if (count < 21 && state) {
            check = 0;
            state_warning = 1;
        }
        lessonDbHelper.updateCheckTimer(String.valueOf(data), new Lesson("Đúng " + count + " câu / " + (19 - minutes) + " phút", check, (int) (1140000 - time_left), state_warning,number_warning,number_null_answer,count,number_wrong));
    }

    @SuppressLint("SetTextI18n")
    private void showListDialog() {
        final Dialog dialog = new Dialog(StartLessonActivity.this);
        dialog.setContentView(R.layout.dialog_list);
        dialog.setCanceledOnTouchOutside(false);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        TextView name_list = dialog.findViewById(R.id.tv_name_list);
        Button bt_list = dialog.findViewById(R.id.bt_close_list);
        RecyclerView recyclerView = dialog.findViewById(R.id.recycler_list);
        //
        name_list.setText("Đề " + data);
        //
        GridLayoutManager layoutManager = new GridLayoutManager(getApplicationContext(), 5);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setNestedScrollingEnabled(false);
        listCheckQuesAdapter = new ListCheckQuesAdapter(questionList, getApplicationContext());
        recyclerView.setAdapter(listCheckQuesAdapter);
        listCheckQuesAdapter.setItemClickListener(new ListCheckQuesAdapter.ClickListener() {
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

    @SuppressLint("SetTextI18n")
    private void initView() {
        tv_ques_count = findViewById(R.id.tv_pos);
        viewPager = findViewById(R.id.view_pager);
        back = findViewById(R.id.iv_back);
        next = findViewById(R.id.iv_next);
        tv_ques_count_timer = findViewById(R.id.tv_count_timer);

        title = findViewById(R.id.tv_title);
        end = findViewById(R.id.tv_end_toolbar);
        iv_back = findViewById(R.id.iv_back_toolbar);
        reset = findViewById(R.id.iv_add_toolbar);
        title.setText("Đề " + data);
        reset.setImageResource(R.drawable.ic_menu);
        //------
        end.setOnClickListener(this);
        iv_back.setOnClickListener(this);
        reset.setOnClickListener(this);
        //------
    }

    @SuppressLint("SetTextI18n")
    private void showDialogEnd() {
        final Dialog dialog = new Dialog(StartLessonActivity.this);
        dialog.setContentView(R.layout.dialog_pre_start);
        dialog.setCanceledOnTouchOutside(false);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        TextView lesson = dialog.findViewById(R.id.tv_lesson);
        TextView oke = dialog.findViewById(R.id.tv_ok_start);
        TextView content = dialog.findViewById(R.id.tv_content_dialog);
        Button close = dialog.findViewById(R.id.bt_close_start);
        lesson.setText("Thông báo");
        content.setText("Bạn có muốn kết thúc bài thi không?");
        oke.setText("Đồng ý");
        oke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishLesson();
                dialog.dismiss();
            }
        });
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    @Override
    public void onBackPressed() {
        if (backPressedTime + 2000 > System.currentTimeMillis()) {
            finishLesson();
        } else {
            CustomToast.makeText(this, "Nhấn lần nữa để kết thúc bài thi !", CustomToast.LENGTH_SHORT, CustomToast.ERROR).show();
        }
        backPressedTime = System.currentTimeMillis();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        finishLesson();
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_back_toolbar:
            case R.id.tv_end_toolbar:
                showDialogEnd();
                break;
            case R.id.iv_add_toolbar:
                showListDialog();
                break;

        }
    }
}
