package com.nam.banglaixea1.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.google.android.material.navigation.NavigationView;
import com.google.gson.Gson;
import com.nam.banglaixea1.Adapter.FunAdapter;

import com.nam.banglaixea1.Adapter.ListAdapter;
import com.nam.banglaixea1.Adapter.ListCheckQuesAdapter;
import com.nam.banglaixea1.Module.CustomToast;
import com.nam.banglaixea1.Module.Fun;
import com.nam.banglaixea1.Module.Question;
import com.nam.banglaixea1.R;
import com.nam.banglaixea1.SQLite.QuesDbHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import static maes.tech.intentanim.CustomIntent.customType;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private final int NULL = -1;
    private DrawerLayout drawerLayout;
    private Toolbar toolbar;

    private ImageSlider imageSlider;
    private RecyclerView recyclerView;
    private FunAdapter adapter;
    private TextView textView;

    private Random random;
    private QuesDbHelper dbHelper;
    private List<Question> list;
    private List<Question> wrong_list = new ArrayList<>();
    private int count = 0;
    private String jsonQuestion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        dbHelper = QuesDbHelper.getInstance(getApplicationContext());

        list = dbHelper.getQuestions();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getYour_answer() != list.get(i).getAnswer() && list.get(i).getYour_answer() != NULL) {
                count++;
                wrong_list.add(new Question(
                        list.get(i).getId(),
                        list.get(i).getQuestion(),
                        list.get(i).getOption1(),
                        list.get(i).getOption2(),
                        list.get(i).getOption3(),
                        list.get(i).getOption4(),
                        list.get(i).getAnswer(),
                        list.get(i).getYour_answer(),
                        list.get(i).getCategory(),
                        list.get(i).getQuestion_image(),
                        list.get(i).getWarning()
                ));
            }
        }
        Gson gson = new Gson();
        jsonQuestion = gson.toJson(wrong_list);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        showListImage();
        showListFun();
        showNote();
    }

    private void showNote() {
        String[] note = {getResources().getString(R.string.a1),
                getResources().getString(R.string.a1),
                getResources().getString(R.string.a2),
                getResources().getString(R.string.a3),
                getResources().getString(R.string.a4),
                getResources().getString(R.string.a5),
                getResources().getString(R.string.a6),
                getResources().getString(R.string.a7),
                getResources().getString(R.string.a8),
                getResources().getString(R.string.a9),
                getResources().getString(R.string.a10),
                getResources().getString(R.string.a11),
                getResources().getString(R.string.a12),
                getResources().getString(R.string.a13),
                getResources().getString(R.string.a14),
                getResources().getString(R.string.a15),
                getResources().getString(R.string.a16),
                getResources().getString(R.string.a17),
                getResources().getString(R.string.a18),
                getResources().getString(R.string.a19),
                getResources().getString(R.string.a20),
        };
        random = new Random();
        int index = random.nextInt(note.length - 0) + 0;
        textView.setText(note[index]);
    }

    private void showListFun() {
        List<Fun> list = new ArrayList<>();
        list.add((new Fun(R.drawable.list, getResources().getString(R.string.fun1))));
        list.add((new Fun(R.drawable.books, getResources().getString(R.string.fun2))));
        list.add((new Fun(R.drawable.fail, getResources().getString(R.string.fun6))));
        list.add((new Fun(R.drawable.judge, getResources().getString(R.string.fun4))));
        list.add((new Fun(R.drawable.idea, getResources().getString(R.string.fun5))));
        list.add((new Fun(R.drawable.parking, getResources().getString(R.string.fun3))));

        GridLayoutManager layoutManager = new GridLayoutManager(getApplicationContext(), 3);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setNestedScrollingEnabled(false);
        adapter = new FunAdapter(list, getApplicationContext());
        recyclerView.setAdapter(adapter);
        adapter.setItemClickListener(new FunAdapter.ClickListener() {
            @Override
            public void onItemClick(int position, View v) {
                if (position == 5) {
                    startActivity(new Intent(getApplicationContext(), FigureActivity.class));
                    customType(MainActivity.this, "left-to-right");
                } else if (position == 4) {
                    startActivity(new Intent(getApplicationContext(), NoteActivity.class));
                    customType(MainActivity.this, "left-to-right");
                } else if (position == 1) {
                    startActivity(new Intent(getApplicationContext(), StartActivity.class));
                    customType(MainActivity.this, "left-to-right");
                } else if (position == 0) {
                    startActivity(new Intent(getApplicationContext(), LessonActivity.class));
                    customType(MainActivity.this, "left-to-right");
                } else if (position == 3) {
                    startActivity(new Intent(getApplicationContext(), RulesActivity.class));
                    customType(MainActivity.this, "left-to-right");
                }
                else if (position == 2) {
                    if (count != 0) {
                        Intent intent = new Intent(MainActivity.this, WrongQuesActivity.class);
                        intent.putExtra("LIST", jsonQuestion);
                        startActivity(intent);
                        customType(MainActivity.this, "left-to-right");
                    } else {
                        CustomToast.makeText(getApplicationContext(),"Bạn chưa có câu sai !",CustomToast.LENGTH_SHORT,CustomToast.ERROR).show();
                    }
                }
            }
        });
    }

    private void initView() {
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.app);
        setSupportActionBar(toolbar);
        drawerLayout = findViewById(R.id.drawer_layout);
        imageSlider = findViewById(R.id.slider);
        recyclerView = findViewById(R.id.recycler_fun);
        textView = findViewById(R.id.tv_note);
        NavigationView navigationView=findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.user_manual:
                startActivity(new Intent(MainActivity.this,UserManualActivity.class));
                customType(MainActivity.this, "left-to-right");
                break;
            case R.id.rate:
            case R.id.app_others:
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store")));
                break;
            case R.id.feedback:
                break;
            case R.id.share:
                Intent share = new Intent(Intent.ACTION_SEND);
                share.setType("text/plain");
                String shareBody = "https://play.google.com/store/apps/details?id=com.socialnmobile.dictapps.notepad.color.note";
                String shareSubject = getResources().getString(R.string.app_name);
                share.putExtra(Intent.EXTRA_SUBJECT, shareSubject);
                share.putExtra(Intent.EXTRA_TEXT, shareBody);
                startActivity(Intent.createChooser(share, "Chia sẻ với ..."));
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
    private void showListImage() {
        List<SlideModel> slideModels = new ArrayList<>();
        slideModels.add(new SlideModel(R.drawable.image_2, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.image_3, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.image_4, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.image_5, ScaleTypes.FIT));
        imageSlider.setImageList(slideModels, ScaleTypes.FIT);
    }
    private void showDialogExit() {
        final Dialog dialog = new Dialog(MainActivity.this);
        dialog.setContentView(R.layout.dialog_exit_app);
        dialog.setCanceledOnTouchOutside(false);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        TextView oke = dialog.findViewById(R.id.tv_ok_exit);
        Button close = dialog.findViewById(R.id.bt_close_exit);

        oke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent homeIntent = new Intent(Intent.ACTION_MAIN);
                homeIntent.addCategory(Intent.CATEGORY_HOME);
                homeIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(homeIntent);
                dialog.dismiss();
            }
        });
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store")));
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            showDialogExit();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (dbHelper != null) {
            dbHelper.close();
        }
    }


}