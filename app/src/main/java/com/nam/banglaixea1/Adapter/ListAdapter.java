package com.nam.banglaixea1.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nam.banglaixea1.Module.Question;
import com.nam.banglaixea1.R;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {
    List<Question> list;
    Context context;

    public ListAdapter(List<Question> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_question, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Question question=list.get(position);
        if(position<9){
            holder.item_list_question.setText("0"+(position+1));
        }else{
            holder.item_list_question.setText(""+(position+1));
        }
        if(question.getYour_answer()==question.getAnswer()){
            holder.item_list_question.setBackgroundResource(R.drawable.correct);
        }else if(question.getYour_answer()!=question.getAnswer() && question.getYour_answer() !=-1){
            holder.item_list_question.setBackgroundResource(R.drawable.wrong);
        }else if(question.getYour_answer() == -1){
            holder.item_list_question.setBackgroundResource(R.drawable.dfault);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView item_list_question;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            item_list_question=itemView.findViewById(R.id.item_list_question);
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
