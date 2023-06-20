package com.helcode.examplerecyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
   Context context;
   ArrayList name_id,lastname_id;

    public RecyclerAdapter(Context context, ArrayList name_id, ArrayList lastname_id) {
        this.context = context;
        this.name_id = name_id;
        this.lastname_id = lastname_id;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(context).inflate(R.layout.item_user,parent,false);
       ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

       holder.text.setText(String.valueOf(name_id.get(position)));
       holder.text2.setText(String.valueOf(lastname_id.get(position)));
    }

    @Override
    public int getItemCount() {
        return name_id.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView text,text2;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            text = itemView.findViewById(R.id.item_texto);
            text2= itemView.findViewById(R.id.Text2);
        }
    }
}
