package com.nam.banglaixea1.Fragment;

import android.graphics.Color;
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

public class Fragment_Note_A extends Fragment {
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
        list.add(new Note("Lý thuyết",getResources().getString(R.string.note1), R.color.color1));
        list.add(new Note("Biển báo",getResources().getString(R.string.note2), R.color.color2));
        list.add(new Note("Sa hình",getResources().getString(R.string.note3),  R.color.color3));
        adapter=new NoteAdapter(list,getContext());
    }
}
