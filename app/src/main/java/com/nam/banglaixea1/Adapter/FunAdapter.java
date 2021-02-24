package com.nam.banglaixea1.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nam.banglaixea1.Module.Fun;
import com.nam.banglaixea1.R;

import java.util.List;

public class FunAdapter extends RecyclerView.Adapter<FunAdapter.ViewHolder> {
    List<Fun> list;
    Context context;

    public FunAdapter(List<Fun> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_fun, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Fun fun=list.get(position);
        holder.imageView.setImageResource(fun.getImage());
        holder.textView.setText(fun.getName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView imageView;
        TextView textView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.iv_fun);
            textView=itemView.findViewById(R.id.tv_fun);
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
