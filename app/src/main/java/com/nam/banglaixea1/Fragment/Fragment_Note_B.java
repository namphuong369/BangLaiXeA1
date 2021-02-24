package com.nam.banglaixea1.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.nam.banglaixea1.Adapter.NoteAdapter;
import com.nam.banglaixea1.Module.Note;
import com.nam.banglaixea1.R;

import java.util.ArrayList;
import java.util.List;

public class Fragment_Note_B extends Fragment {
    private View view;
    private RecyclerView recyclerView;
    private List<Note> list;
    private NoteAdapter adapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_a,container,false);
        recyclerView=view.findViewById(R.id.recycler_a);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
        return view;
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        list=new ArrayList<>();
        list.add(new Note("Hướng dẫn thi thực hành",getResources().getString(R.string.note9),R.color.color2));
        list.add(new Note("Ý nghĩa của việc chạy sa hình",getResources().getString(R.string.note4), R.color.color4));
        list.add(new Note("Vòng số 8",getResources().getString(R.string.note5), R.color.color3));
        list.add(new Note("Đi đường hẹp",getResources().getString(R.string.note6),  R.color.color6));
        list.add(new Note("Đi theo đường có vạch cản",getResources().getString(R.string.note7),  R.color.color1));
        list.add(new Note("Đi đường gồ gề",getResources().getString(R.string.note8),  R.color.color2));
        list.add(new Note("Lưu ý",getResources().getString(R.string.note10),  R.color.color5));
        adapter=new NoteAdapter(list,getContext());
    }
}
