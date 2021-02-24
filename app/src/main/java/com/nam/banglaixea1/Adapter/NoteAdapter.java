package com.nam.banglaixea1.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nam.banglaixea1.Module.Note;
import com.nam.banglaixea1.R;

import java.util.List;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.ViewHolder> {
    List<Note> list;
    Context context;

    public NoteAdapter(List<Note> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Note note=list.get(position);
        holder.color.setBackgroundResource(note.getColor());
        holder.title.setText(note.getTitle());
        holder.content.setText(note.getContent());

        boolean isExpan=note.isExpandable();
        holder.linearLayout_content.setVisibility(isExpan?View.VISIBLE:View.GONE);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView color,title,content;
        LinearLayout linear_layout,linearLayout_content;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            color=itemView.findViewById(R.id.view_color);
            title=itemView.findViewById(R.id.tv_title_row);
            content=itemView.findViewById(R.id.tv_content_row);
            linear_layout=itemView.findViewById(R.id.linear_layout);
            linearLayout_content=itemView.findViewById(R.id.linear_layout_content);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Note note=list.get(getAdapterPosition());
                    note.setExpandable(!note.isExpandable());
                    notifyDataSetChanged();getAdapterPosition();
                }
            });
        }
    }
}
