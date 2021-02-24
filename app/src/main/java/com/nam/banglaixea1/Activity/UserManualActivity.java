package com.nam.banglaixea1.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.nam.banglaixea1.R;

import static maes.tech.intentanim.CustomIntent.customType;

public class UserManualActivity extends AppCompatActivity {

    private TextView title, end;
    private ImageView back, reset;
    private TextView note1, note2, note3;
    private TextView next_activity;
    private Animation a1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_manual);
        initView();
        setAction(note1,1000);
        setAction(note2,2000);
        setAction(note3,3000);
        setAction(next_activity,4000);

        next_activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UserManualActivity.this, MainActivity.class));
                customType(UserManualActivity.this, "left-to-right");
            }
        });

    }

    private void initView() {
        title = findViewById(R.id.tv_title);
        end = findViewById(R.id.tv_end_toolbar);
        back = findViewById(R.id.iv_back_toolbar);
        reset = findViewById(R.id.iv_add_toolbar);
        title.setText("Hướng dẫn sử dụng");
        end.setVisibility(View.GONE);
        reset.setVisibility(View.GONE);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UserManualActivity.this, MainActivity.class));
                customType(UserManualActivity.this, "right-to-left");
            }
        });
        //--------------
        a1 = AnimationUtils.loadAnimation(this, R.anim.anim_alpha);

        note1 = findViewById(R.id.user_manual_note1);
        note2 = findViewById(R.id.user_manual_note2);
        note3 = findViewById(R.id.user_manual_note3);
        next_activity = findViewById(R.id.user_manual_bt);
        note1.setVisibility(View.INVISIBLE);
        note2.setVisibility(View.INVISIBLE);
        note3.setVisibility(View.INVISIBLE);
        next_activity.setVisibility(View.INVISIBLE);
    }

    private void setAction(final TextView imageView, final long time) {
        new Thread() {
            @Override
            public void run() {
                try {
                    synchronized (this){
                        wait(time);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                imageView.setVisibility(View.VISIBLE);
                                imageView.startAnimation(a1);
                            }
                        });
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }
}