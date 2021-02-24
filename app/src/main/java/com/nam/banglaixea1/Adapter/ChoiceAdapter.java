package com.nam.banglaixea1.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nam.banglaixea1.Module.Choice;
import com.nam.banglaixea1.R;

import java.util.List;

public class ChoiceAdapter extends RecyclerView.Adapter<ChoiceAdapter.ViewHolder> {
    List<Choice> list;
    Context context;

    public ChoiceAdapter(List<Choice> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_choice, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Choice choice=list.get(position);
        holder.color.setBackgroundResource(choice.getColor());
        holder.title.setText(choice.getName());
        holder.warning.setText(choice.getWarning());
        holder.count.setText(""+choice.getNumber());
        holder.total.setText("/ "+choice.getNumber_total());
        holder.number.setText(choice.getText_total());
        holder.pb.setMax(choice.getNumber_total());
        holder.pb.setProgress(choice.getNumber());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView title,number,warning,count,total;
        ProgressBar pb;
        TextView color;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.tv_title_choice);
            number=itemView.findViewById(R.id.tv_number_choice);
            warning=itemView.findViewById(R.id.tv_number_warning);
            count=itemView.findViewById(R.id.tv_number);
            total=itemView.findViewById(R.id.tv_total);
            pb=itemView.findViewById(R.id.pb_choice);
            color=itemView.findViewById(R.id.view_color);
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
