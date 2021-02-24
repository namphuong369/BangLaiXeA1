package com.nam.banglaixea1.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nam.banglaixea1.Module.Lesson;
import com.nam.banglaixea1.R;

import java.util.List;

public class LessonAdapter extends RecyclerView.Adapter<LessonAdapter.ViewHolder> {
    List<Lesson> list;
    Context context;

    public LessonAdapter(List<Lesson> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lesson, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Lesson lesson = list.get(position);
        holder.color.setBackgroundResource(lesson.getColor());
        if (lesson.getNumber() < 9) {
            holder.number.setText("0" + lesson.getNumber());
        } else {
            holder.number.setText(lesson.getNumber());
        }
        holder.title.setText("Đề số "+lesson.getNumber());
        holder.content.setText(lesson.getContent());
        if(lesson.getCheck()==-1){
            lesson.setResult("LÀM");
            holder.result.setTextColor(Color.parseColor("#112233"));
        }else if(lesson.getCheck()==0){
            lesson.setResult("TRƯỢT");
            holder.result.setTextColor(Color.parseColor("#F44336"));
        }else if(lesson.getCheck()==1){
            lesson.setResult("ĐỖ");
            holder.result.setTextColor(Color.parseColor("#4CAF50"));
        }
        holder.result.setText(lesson.getResult());
        if(lesson.getState()==0){
            holder.warning.setVisibility(View.INVISIBLE);
        }else if(lesson.getState()==1){
            holder.warning.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView color, number, title, content, result,warning;
        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            color = itemView.findViewById(R.id.view_color);
            number = itemView.findViewById(R.id.tv_number_lesson);
            title = itemView.findViewById(R.id.tv_lesson);
            content = itemView.findViewById(R.id.tv_content_lesson);
            result = itemView.findViewById(R.id.tv_result_lesson);
            imageView = itemView.findViewById(R.id.iv_start_lesson);
            warning=itemView.findViewById(R.id.tv_warning_lesson);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            listener.onItemClick(getAdapterPosition(), v);
        }
    }

    private ClickListener listener;

    public void setItemClickListener(ClickListener clickListener) {
        listener = clickListener;
    }

    public interface ClickListener {
        void onItemClick(int position, View v);
    }
}
