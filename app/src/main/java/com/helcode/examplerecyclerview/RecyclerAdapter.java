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
   ArrayList<ModelUser> listaItem;

   RecyclerAdapter(Context context,ArrayList<ModelUser> arraylist){
       this.context=context;
       this.listaItem = arraylist;
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

       holder.text.setText(listaItem.get(position).text);
    }

    @Override
    public int getItemCount() {
        return listaItem.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView text;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            text = itemView.findViewById(R.id.item_texto);
        }
    }
}
