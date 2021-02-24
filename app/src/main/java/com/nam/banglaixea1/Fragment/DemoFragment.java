package com.nam.banglaixea1.Fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.nam.banglaixea1.R;

public class DemoFragment extends Fragment {
    private LinearLayout linearLayout;

    public DemoFragment() {
    }

    public DemoFragment(int contentLayoutId) {
        super(contentLayoutId);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_demo, container, false);
        linearLayout = view.findViewById(R.id.bg_linear);
        int number = getArguments().getInt("mes");
        setBackGround(number);
        return view;
    }

    private void setBackGround(int i) {
        if (i == 1) {
            linearLayout.setBackgroundColor(Color.RED);
        } else if (i == 2) {
            linearLayout.setBackgroundColor(Color.YELLOW);
        } else if (i == 3) {
            linearLayout.setBackgroundColor(Color.BLACK);
        } else if (i == 4) {
            linearLayout.setBackgroundColor(Color.BLUE);
        } else if (i == 5) {
            linearLayout.setBackgroundColor(Color.GREEN);
        }
    }
}
