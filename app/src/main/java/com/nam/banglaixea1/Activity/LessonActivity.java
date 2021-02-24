package com.nam.banglaixea1.Activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.nam.banglaixea1.Adapter.LessonAdapter;
import com.nam.banglaixea1.Adapter.ListAdapter;
import com.nam.banglaixea1.Module.Category;
import com.nam.banglaixea1.Module.CustomToast;
import com.nam.banglaixea1.Module.Lesson;
import com.nam.banglaixea1.Module.Question;
import com.nam.banglaixea1.R;
import com.nam.banglaixea1.SQLite.LessonDbHelper;
import com.nam.banglaixea1.SQLite.QuesDbHelper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import static maes.tech.intentanim.CustomIntent.customType;

public class LessonActivity extends AppCompatActivity implements View.OnClickListener {


    private RecyclerView recyclerView;
    private List<Lesson> list;
    private List<Question> questions = new ArrayList<>();
    private List<Question> new_questions = new ArrayList<>();
    private List<Question> list_questions=new ArrayList<>();
    private LessonAdapter adapter;
    private Question ques;

    private ListAdapter listAdapter;
    private LessonDbHelper lessonDbHelper;
    private QuesDbHelper quesDbHelper;

    private TextView title, end;
    private ImageView back, reset;

    int[] color = {R.color.color1, R.color.color2, R.color.color3, R.color.color4, R.color.color5, R.color.color6, R.color.color7,
            R.color.color8, R.color.color9, R.color.color10, R.color.color11, R.color.color12, R.color.color13, R.color.colorAccent, R.color.colorPrimary, R.color.colorPrimaryDark};
    private Random random;
    private int index = 0;
    private int count=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson);
        lessonDbHelper = LessonDbHelper.getInstance(getApplicationContext());
        quesDbHelper = QuesDbHelper.getInstance(getApplicationContext());
        initView();
        setData();
    }

    private void setData() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setHasFixedSize(true);
        adapter = new LessonAdapter(list, LessonActivity.this);
        recyclerView.setAdapter(adapter);
        adapter.setItemClickListener(new LessonAdapter.ClickListener() {
            @Override
            public void onItemClick(int position, View v) {
                if (list.get(position).getCheck() == 0 || list.get(position).getCheck() == 1) {
                    showDialogResult(position+1,list.get(position).getResult(),list.get(position).getTimer(),list.get(position).getNumber_wrong_answer(),list.get(position).getNumber_warning(),list.get(position).getNumber_correct_answer(),list.get(position).getNumber_null_answer());
                } else {
                    showDialogStart("Đề số " + list.get(position).getNumber(), position + 1);
                }
            }
        });
    }

    private void initView() {
        title = findViewById(R.id.tv_title);
        end = findViewById(R.id.tv_end_toolbar);
        back = findViewById(R.id.iv_back_toolbar);
        reset = findViewById(R.id.iv_add_toolbar);
        title.setText("Thi sát hạch");
        end.setVisibility(View.GONE);
        reset.setImageResource(R.drawable.ic_add);
        //------
        back.setOnClickListener(this);
        reset.setOnClickListener(this);
        //------
        recyclerView = findViewById(R.id.recycler_lesson);
        list = lessonDbHelper.getLesson();
        random = new Random();
    }

    private void showDialogAdd() {
        final Dialog dialog = new Dialog(LessonActivity.this);
        dialog.setContentView(R.layout.dialog_add_lesson);
        dialog.setCanceledOnTouchOutside(false);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        TextView oke = dialog.findViewById(R.id.tv_ok_add);
        Button close = dialog.findViewById(R.id.bt_close_add);
        index = random.nextInt(color.length - 0) + 0;
        oke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list.clear();
                lessonDbHelper.addNewLesson(new Lesson(color[index], "25 câu / 19 phút", -1, 0,0));
                list = lessonDbHelper.getLesson();
                setData();
                recyclerView.scrollToPosition(list.size() - 1);
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

    private void showDialogStart(String name, final int count) {
        final Dialog dialog = new Dialog(LessonActivity.this);
        dialog.setContentView(R.layout.dialog_pre_start);
        dialog.setCanceledOnTouchOutside(false);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        TextView lesson = dialog.findViewById(R.id.tv_lesson);
        TextView oke = dialog.findViewById(R.id.tv_ok_start);
        Button close = dialog.findViewById(R.id.bt_close_start);
        lesson.setText(name);
        createListQuestion(1, 5, count);
        createListQuestion(2, 1, count);
        createListQuestion(3, 4, count);
        createListQuestion(4, 3, count);
        Collections.shuffle(new_questions);
        createListQuestion(5, 6, count);
        createListQuestion(6, 6, count);
        oke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < new_questions.size(); i++) {
                    Question question = new_questions.get(i);
                    lessonDbHelper.addQuestion(new Question(question.getQuestion(),
                            question.getOption1(),
                            question.getOption2(),
                            question.getOption3(),
                            question.getOption4(),
                            question.getAnswer(),
                            question.getYour_answer(),
                            count,
                            question.getQuestion_image(),
                            question.getWarning()
                    ));
                }
                dialog.dismiss();
                Intent intent = new Intent(LessonActivity.this, StartLessonActivity.class);
                intent.putExtra("DATA", count);
                startActivity(intent);
                customType(LessonActivity.this, "left-to-right");
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
    private void showDialogResult(final int number, String rst, int tm, int wr, int wn, int cr,int null_answer) {
        final Dialog dialog = new Dialog(LessonActivity.this);
        dialog.setContentView(R.layout.dialog_result_lesson);
        dialog.setCanceledOnTouchOutside(false);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        TextView lesson = dialog.findViewById(R.id.tv_lesson_dialog_result);
        TextView result = dialog.findViewById(R.id.tv_result_dialog_result);
        TextView correct = dialog.findViewById(R.id.tv_correct_dialog_result);
        TextView timer = dialog.findViewById(R.id.tv_timer_dialog_result);
        TextView wrong = dialog.findViewById(R.id.tv_wrong_dialog_result);
        TextView warning = dialog.findViewById(R.id.tv_warning_dialog_result);
        TextView null_as = dialog.findViewById(R.id.tv_null_dialog_result);
        final TextView see_more = dialog.findViewById(R.id.tv_seemore_dialog_result);
        final LinearLayout linearLayout=dialog.findViewById(R.id.linear_list_dialog_result);
        RecyclerView recyclerView=dialog.findViewById(R.id.recycler_dialog_result);
        TextView oke = dialog.findViewById(R.id.tv_ok_dialog_result);
        Button close = dialog.findViewById(R.id.bt_cancel_dialog_result);

        lesson.setText("Đề "+number);
        correct.setText(""+cr);
        result.setText(rst);
        if(result.getText().toString().equalsIgnoreCase("TRƯỢT")){
            result.setTextColor(Color.parseColor("#F44336"));
        }else if(result.getText().toString().equalsIgnoreCase("ĐỖ")){
            result.setTextColor(Color.parseColor("#4CAF50"));
        }
        int minutes =  (tm / 1000) / 60;
        int seconds =  (tm / 1000) % 60;
        String timeFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);
        timer.setText(timeFormatted);
        wrong.setText(""+wr);
        warning.setText(""+wn);
        null_as.setText(""+null_answer);

        list_questions=lessonDbHelper.getQuestions(number);
        GridLayoutManager layoutManager = new GridLayoutManager(getApplicationContext(), 5);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        listAdapter = new ListAdapter(list_questions, LessonActivity.this);
        recyclerView.setAdapter(listAdapter);
        listAdapter.setItemClickListener(new ListAdapter.ClickListener() {
            @Override
            public void onItemClick(int position, View v) {

            }
        });

        see_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                if(count%2==0){
                    linearLayout.setVisibility(View.GONE);
                    see_more.setText("Xem thêm");
                }else {
                    linearLayout.setVisibility(View.VISIBLE);
                    see_more.setText("Thu gọn");
                }
            }
        });
        oke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i=0;i<list_questions.size();i++){
                    Question question=list_questions.get(i);
                    lessonDbHelper.updateYourAnswer(String.valueOf(question.getId()),new Question(-1));
                }
                Intent intent = new Intent(LessonActivity.this, StartLessonActivity.class);
                intent.putExtra("DATA", number);
                startActivity(intent);
                customType(LessonActivity.this, "left-to-right");
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
    private void createListQuestion(int category, int limit, int lesson) {
        questions = quesDbHelper.getQuestions(category);
        Collections.shuffle(questions);
        for (int i = 0; i < limit; i++) {
            ques = questions.get(i);
            new_questions.add(new Question(ques.getQuestion(),
                    ques.getOption1(),
                    ques.getOption2(),
                    ques.getOption3(),
                    ques.getOption4(),
                    ques.getAnswer(),
                    -1,
                    lesson,
                    ques.getQuestion_image(),
                    ques.getWarning()
            ));
        }
        questions.clear();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (lessonDbHelper != null && quesDbHelper != null) {
            lessonDbHelper.close();
            quesDbHelper.close();
        }
        list.clear();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_back_toolbar:
                startActivity(new Intent(LessonActivity.this, MainActivity.class));
                customType(LessonActivity.this, "right-to-left");
                break;
            case R.id.iv_add_toolbar:
                showDialogAdd();
                break;

        }
    }
}