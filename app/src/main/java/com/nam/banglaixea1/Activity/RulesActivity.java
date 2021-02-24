package com.nam.banglaixea1.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.barteksc.pdfviewer.PDFView;
import com.nam.banglaixea1.R;

import static maes.tech.intentanim.CustomIntent.customType;

public class RulesActivity extends AppCompatActivity {
    private TextView title, end;
    private ImageView back, reset;
    private PDFView pdfView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rules);
        initView();
        pdfView.fromAsset("xu_phat.pdf").load();
    }
    private void initView() {
        title = findViewById(R.id.tv_title);
        end = findViewById(R.id.tv_end_toolbar);
        back = findViewById(R.id.iv_back_toolbar);
        reset = findViewById(R.id.iv_add_toolbar);
        title.setText(getResources().getString(R.string.fun4));
        end.setVisibility(View.GONE);
        reset.setVisibility(View.GONE);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RulesActivity.this, MainActivity.class));
                customType(RulesActivity.this, "right-to-left");
            }
        });
        pdfView=findViewById(R.id.view_pdf);
    }
}