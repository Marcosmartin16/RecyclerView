package com.first.recyclerview;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MiAdaptadorSimple extends RecyclerView.Adapter<MiAdaptadorSimple.ViewHolder> {

    private List<String> mData;
    private LayoutInflater mInflater;

    private int pos = 0;
    public int getPos(){
        return  this.pos;
    }
    public void decrementarPos(){
        this.pos --;
    }

    MiAdaptadorSimple(Context context, List<String> data){
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

        //si pulso se pone rojo
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView myTv = view.findViewById(R.id.tvAnimalnombre);
                ColorDrawable viewColor = (ColorDrawable) myTv.getBackground();

                if (viewColor == null)myTv.setBackgroundColor(Color.RED);
                else{
                    int colorId = viewColor.getColor();
                    if (colorId == Color.WHITE) myTv.setBackgroundColor(Color.RED);
                    else myTv.setBackgroundColor(Color.WHITE);
                }
                pos = position;
            }
        });

        //si mantengo pulsado cambia el fondo a azul
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                TextView myTV = view.findViewById(R.id.tvAnimalnombre);
                myTV.setBackgroundColor (Color.BLUE);
                return false;
            }
        });
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
