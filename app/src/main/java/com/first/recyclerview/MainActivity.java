package com.first.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

     MiAdaptadorSimple adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<String> animalnombres = new ArrayList<>();
        animalnombres.add("caballo");
        animalnombres.add("leon");
        animalnombres.add("tigre");
        animalnombres.add("aguila");
        animalnombres.add("rinoceronte");
        animalnombres.add("araña");
        animalnombres.add("oso");
        animalnombres.add("mariposa");
        animalnombres.add("leopardo");
        animalnombres.add("serpiente");
        animalnombres.add("gato");
        animalnombres.add("vaca");
        animalnombres.add("cerdo");
        animalnombres.add("pez payaso");

        RecyclerView recyclerView = findViewById(R.id.rvAnimales);
        LinearLayoutManager mLayout = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayout);
        adapter = new MiAdaptadorSimple(this, animalnombres);
        recyclerView.setAdapter(adapter);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),mLayout.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);

        DefaultItemAnimator miDefaultItemAnimator = new DefaultItemAnimator();
        recyclerView.setItemAnimator(miDefaultItemAnimator);
        recyclerView.animate();



        TextView tvAnimalAnadido = findViewById(R.id.tvAnimal);
        Button bAnadir = findViewById(R.id.bAnadir);
        bAnadir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String item = tvAnimalAnadido.getText().toString();
                int poscionInsercion = (adapter.getPos()>=0)? adapter.getPos()+1:0;
                animalnombres.add(poscionInsercion, item);
                adapter.notifyItemInserted(poscionInsercion);
                adapter.notifyItemRangeChanged(0,animalnombres.size());
                recyclerView.scheduleLayoutAnimation();
            }
        });

        Button bBorrar = findViewById(R.id.bBorrar);
        bBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int posicion = adapter.getPos();
                if(adapter.getPos() >= 0){
                    animalnombres.remove(adapter.getPos());
                    adapter.notifyItemRemoved(adapter.getPos());
                    adapter.notifyItemRangeChanged(0,animalnombres.size());
                    adapter.decrementarPos();
                    recyclerView.scheduleLayoutAnimation();
                }
            }
        });
    }
}