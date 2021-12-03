package com.first.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MiAdaptador extends RecyclerView.Adapter<MiAdaptador.ViewHolder> {

    private List<String> mData;
    private LayoutInflater mInflater;

    MiAdaptador(Context context, List<String> data){
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String animal = mData.get(position);
        holder.myTextView.setText(animal);


    }

    @Override
    public int getItemCount() {
        return mData.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView myTextView;

        ViewHolder(View itemView){
            super(itemView);
            myTextView = itemView.findViewById(R.id.tvAnimalnombre);
        }
    }
}
