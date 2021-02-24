package com.nam.banglaixea1.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nam.banglaixea1.Module.Figure;
import com.nam.banglaixea1.R;

import java.util.List;

public class FigureBAdapter extends RecyclerView.Adapter<FigureBAdapter.ViewHolder> {
    List<Figure> list;
    Context context;

    public FigureBAdapter(List<Figure> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_figure, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Figure figure=list.get(position);
        holder.figure.setImageResource(figure.getImage());
        holder.title.setText(figure.getTitle());
        holder.content.setText(figure.getContent());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView figure;
        TextView title,content;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            figure=itemView.findViewById(R.id.iv_figure);
            title=itemView.findViewById(R.id.tv_title_figure);
            content=itemView.findViewById(R.id.tv_content_figure);
        }
    }
}
