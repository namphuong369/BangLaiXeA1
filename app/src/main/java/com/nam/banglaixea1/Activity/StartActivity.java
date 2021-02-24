package com.nam.banglaixea1.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


import com.nam.banglaixea1.Adapter.ChoiceAdapter;
import com.nam.banglaixea1.Module.Category;
import com.nam.banglaixea1.Module.Choice;
import com.nam.banglaixea1.Module.CustomToast;
import com.nam.banglaixea1.Module.Question;
import com.nam.banglaixea1.R;
import com.nam.banglaixea1.SQLite.QuesDbHelper;

import java.util.ArrayList;
import java.util.List;

import static maes.tech.intentanim.CustomIntent.customType;

public class StartActivity extends AppCompatActivity implements View.OnClickListener{
    private final int NULL = -1;
    private RecyclerView recyclerView;
    private List<Choice> list = new ArrayList<>();
    private ChoiceAdapter adapter;
    private QuesDbHelper dbHelper;

    private List<Category> categoryList;

    private TextView title,end;
    private ImageView back,reset;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        dbHelper = QuesDbHelper.getInstance(getApplicationContext());
        initView();
        addList();
        showData();
    }

    private void showData() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setHasFixedSize(true);
        adapter = new ChoiceAdapter(list, getApplicationContext());
        recyclerView.setAdapter(adapter);
        adapter.setItemClickListener(new ChoiceAdapter.ClickListener() {
            @Override
            public void onItemClick(int position, View v) {
                Intent intent = new Intent(StartActivity.this, QuestionActivity.class);
                intent.putExtra("DATA", position);
                startActivity(intent);
                customType(StartActivity.this, "left-to-right");
            }
        });
    }

    private void initView() {
        title=findViewById(R.id.tv_title);
        end=findViewById(R.id.tv_end_toolbar);
        back=findViewById(R.id.iv_back_toolbar);
        reset=findViewById(R.id.iv_add_toolbar);
        title.setText("Học lý thuyết");
        end.setVisibility(View.GONE);
        reset.setImageResource(R.drawable.ic_reset);
        //------
        back.setOnClickListener(this);
        reset.setOnClickListener(this);
        //------
        recyclerView = findViewById(R.id.recycler_start);
        }
    private void addList(){
        categoryList = dbHelper.getCategory();
        list.add(new Choice(R.color.color6, "Khái niệm và quy tắc", "Gồm " + dbHelper.getQuestions(1).size() + " câu hỏi", categoryList.get(0).getCount(), dbHelper.getQuestions(1).size(), "(18 câu điểm liệt)"));
        list.add(new Choice(R.color.color5, "Văn hóa và đạo đức lái xe", "Gồm " + dbHelper.getQuestions(2).size() + " câu hỏi", categoryList.get(1).getCount(), dbHelper.getQuestions(2).size(), ""));
        list.add(new Choice(R.color.color4, "Câu hỏi điểm liệt", "Gồm " + dbHelper.getQuestions(3).size() + " câu hỏi", categoryList.get(2).getCount(), dbHelper.getQuestions(3).size(), "(20 câu điểm liệt)"));
        list.add(new Choice(R.color.color3, "Kỹ thuật lái xe", "Gồm " + dbHelper.getQuestions(4).size() + " câu hỏi", categoryList.get(3).getCount(), dbHelper.getQuestions(4).size(), "(2 câu điểm liệt)"));
        list.add(new Choice(R.color.color2, "Biển báo đường bộ", "Gồm " + dbHelper.getQuestions(5).size() + " câu hỏi", categoryList.get(4).getCount(), dbHelper.getQuestions(5).size(), ""));
        list.add(new Choice(R.color.color1, "Sa hình", "Gồm " + dbHelper.getQuestions(6).size() + " câu hỏi", categoryList.get(5).getCount(), dbHelper.getQuestions(6).size(), ""));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_back_toolbar:
                startActivity(new Intent(StartActivity.this,MainActivity.class));
                customType(StartActivity.this, "right-to-left");
                break;
            case R.id.iv_add_toolbar:
                showDialogReset();
                break;

        }
    }
    private void showDialogReset() {
        final Dialog dialog = new Dialog(StartActivity.this);
        dialog.setContentView(R.layout.dialog_add_lesson);
        dialog.setCanceledOnTouchOutside(false);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        TextView lesson=dialog.findViewById(R.id.tv_note_reset);
        TextView content=dialog.findViewById(R.id.tv_content_reset);
        TextView oke = dialog.findViewById(R.id.tv_ok_add);
        Button close = dialog.findViewById(R.id.bt_close_add);
        lesson.setText("Thông báo");
        content.setText("Bạn có muốn khởi tạo lại toàn bộ câu hỏi không?");

        oke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i=0;i<6;i++){
                    list.get(i).setNumber(0);
                }
                dialog.dismiss();
                new MyAsyn().execute();
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
        super.onBackPressed();
        startActivity(new Intent(StartActivity.this,MainActivity.class));
        customType(StartActivity.this, "right-to-left");
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (dbHelper != null) {
            dbHelper.close();
        }
    }
    public class MyAsyn extends AsyncTask<Void,Void, Void>{
        public ProgressDialog dialog_process;
        @Override
        protected void onPreExecute() {
            dialog_process=new ProgressDialog(StartActivity.this);
            dialog_process.setMessage("Đang cập nhật ...");
            dialog_process.setCanceledOnTouchOutside(false);
            dialog_process.show();

        }

        @Override
        protected Void doInBackground(Void... voids) {
            for(int i=1;i<7;i++) {
                dbHelper.updateCountQues(String.valueOf(i), new Category(0));
            }
            for(int i=0;i<dbHelper.getQuestions().size();i++){
                if(dbHelper.getQuestions().get(i).getYour_answer()!=NULL){
                    dbHelper.updateYourAnswer(String.valueOf(dbHelper.getQuestions().get(i).getId()),new Question(-1));
                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            showData();
            if (dialog_process.isShowing()) {
                dialog_process.dismiss();
                CustomToast.makeText(getApplicationContext(), "Tạo mới câu hỏi thành công!", CustomToast.LENGTH_SHORT, CustomToast.SUCCESS).show();
            }
        }
    }
}