package com.nam.banglaixea1.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.nam.banglaixea1.Module.Question;
import com.nam.banglaixea1.R;
import com.nam.banglaixea1.SQLite.QuesDbHelper;

import java.util.List;

public class QuestionAdapter extends PagerAdapter {
    private final int NULL = -1;
    private int your_answer = -1;
    private List<Question> list;
    private LayoutInflater layoutInflater;
    private Context context;
    private QuesDbHelper dbHelper;
    private int[] image = {R.drawable.a1, R.drawable.b1, R.drawable.c1, R.drawable.f3, R.drawable.hlenh_1, R.drawable.hlieu_2,
            R.drawable.q1, R.drawable.q11, R.drawable.q12, R.drawable.q14, R.drawable.q15, R.drawable.q16, R.drawable.q18, R.drawable.q19, R.drawable.q2, R.drawable.q20, R.drawable.q22, R.drawable.q23, R.drawable.q25, R.drawable.q26, R.drawable.q28, R.drawable.q31, R.drawable.q32, R.drawable.q35, R.drawable.q36, R.drawable.q37, R.drawable.q38, R.drawable.q39, R.drawable.q4, R.drawable.q40, R.drawable.q41, R.drawable.q43, R.drawable.q44, R.drawable.q45, R.drawable.q46, R.drawable.q47, R.drawable.q48, R.drawable.q50, R.drawable.q53, R.drawable.q55, R.drawable.q56, R.drawable.q57, R.drawable.q58, R.drawable.q59, R.drawable.q60, R.drawable.q61, R.drawable.q62, R.drawable.q7, R.drawable.q8, R.drawable.q9,R.drawable.e19,
            R.drawable.u1, R.drawable.u10, R.drawable.u11, R.drawable.u12, R.drawable.u13, R.drawable.u14, R.drawable.u15, R.drawable.u16, R.drawable.u17, R.drawable.u18, R.drawable.u19, R.drawable.u2, R.drawable.u20, R.drawable.u21, R.drawable.u22, R.drawable.u23, R.drawable.u24, R.drawable.u25, R.drawable.u26, R.drawable.u27, R.drawable.u28, R.drawable.u29, R.drawable.u3, R.drawable.u30, R.drawable.u31, R.drawable.u32, R.drawable.u33, R.drawable.u34, R.drawable.u35, R.drawable.u4, R.drawable.u5, R.drawable.u6, R.drawable.u7, R.drawable.u8, R.drawable.u9
    };

    public QuestionAdapter(List<Question> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.fragment_demo, container, false);
        dbHelper = QuesDbHelper.getInstance(context);
        TextView question;
        ImageView imageView;
        RadioGroup radioGroup;
        final RadioButton rb1, rb2, rb3, rb4;
        View line1, line2;
        question = view.findViewById(R.id.tv_question);
        radioGroup = view.findViewById(R.id.radio_view);
        rb1 = view.findViewById(R.id.rb1);
        rb2 = view.findViewById(R.id.rb2);
        rb3 = view.findViewById(R.id.rb3);
        rb4 = view.findViewById(R.id.rb4);
        imageView = view.findViewById(R.id.iv_question);
        line2 = view.findViewById(R.id.view_2);
        line1 = view.findViewById(R.id.view_1);
        final Question qst = list.get(position);
        question.setText(qst.getQuestion());
        rb1.setText(qst.getOption1());
        rb2.setText(qst.getOption2());
        rb3.setText(qst.getOption3());
        rb4.setText(qst.getOption4());
        if (qst.getOption4().isEmpty()) {
            rb4.setVisibility(View.GONE);
            line2.setVisibility(View.GONE);
        }
        if (qst.getOption3().isEmpty()) {
            rb3.setVisibility(View.GONE);
            line1.setVisibility(View.GONE);
        }

        //Vang DFBF2A Do F44336 Xanh 4CAF50
        if (qst.getYour_answer() != NULL && qst.getYour_answer() == qst.getAnswer()) {
            setDefaultTextAnswer(qst, rb1, rb2, rb3, rb4, "#4CAF50");
        } else if (qst.getYour_answer() != NULL && qst.getYour_answer() != qst.getAnswer()) {
            setDefaultTextAnswer(qst, rb1, rb2, rb3, rb4, "#F44336");
        }
        if (qst.getQuestion_image() != NULL) {
            checkImage(qst, imageView);
        }
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb1:
                        your_answer = 1;
                        break;
                    case R.id.rb2:
                        your_answer = 2;
                        break;
                    case R.id.rb3:
                        your_answer = 3;
                        break;
                    case R.id.rb4:
                        your_answer = 4;
                        break;
                }
                qst.setYour_answer(your_answer);
                showNextQst(qst, rb1, rb2, rb3, rb4);
                dbHelper.updateYourAnswer(String.valueOf(qst.getId()), new Question(qst.getYour_answer()));
            }
        });
        container.addView(view, 0);
        return view;
    }

    private void setDefaultTextAnswer(Question qst, RadioButton rb1, RadioButton rb2, RadioButton rb3, RadioButton rb4, String color) {
        if (qst.getYour_answer() == 1) {
            rb1.setTextColor(Color.parseColor(color));
        } else if (qst.getYour_answer() == 2) {
            rb2.setTextColor(Color.parseColor(color));
        } else if (qst.getYour_answer() == 3) {
            rb3.setTextColor(Color.parseColor(color));
        } else if (qst.getYour_answer() == 4) {
            rb4.setTextColor(Color.parseColor(color));
        }
    }

    private void checkImage(Question qst, ImageView imageView) {
        imageView.setVisibility(View.VISIBLE);
        for (int i = 0; i < image.length; i++) {
            if (qst.getQuestion_image() == image[i]) {
                if (i == 4 || i == 5) {
                    imageView.getLayoutParams().height = 250;
                    imageView.requestLayout();
                }
                imageView.setImageResource(image[i]);
            }
        }
        for (int i = image.length-35; i < image.length; i++) {
            if (qst.getQuestion_image() == image[i]) {
                imageView.getLayoutParams().height = 250;
                imageView.requestLayout();
                imageView.setImageResource(image[i]);
            }
        }
    }

    private void showNextQst(Question question, RadioButton rb1, RadioButton rb2, RadioButton rb3, RadioButton rb4) {
        rb1.setTextColor(Color.parseColor("#112233"));
        rb2.setTextColor(Color.parseColor("#112233"));
        rb3.setTextColor(Color.parseColor("#112233"));
        rb4.setTextColor(Color.parseColor("#112233"));
        switch (question.getAnswer()) {
            case 1:
                setColorAnswer(rb1, rb2, rb3, rb4);
                break;
            case 2:
                setColorAnswer(rb2, rb1, rb3, rb4);
                break;
            case 3:
                setColorAnswer(rb3, rb1, rb2, rb4);
                break;
            case 4:
                setColorAnswer(rb4, rb1, rb2, rb3);
                break;
        }
    }

    private void setColorAnswer(RadioButton rb1, RadioButton rb2, RadioButton rb3, RadioButton rb4) {
        rb1.setTextColor(Color.parseColor("#4CAF50"));
        if (rb2.isChecked()) {
            rb2.setTextColor(Color.parseColor("#F44336"));
            rb1.setTextColor(Color.parseColor("#112233"));
        } else if (rb3.isChecked()) {
            rb3.setTextColor(Color.parseColor("#F44336"));
            rb1.setTextColor(Color.parseColor("#112233"));
        } else if (rb4.isChecked()) {
            rb4.setTextColor(Color.parseColor("#F44336"));
            rb1.setTextColor(Color.parseColor("#112233"));
        }
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
