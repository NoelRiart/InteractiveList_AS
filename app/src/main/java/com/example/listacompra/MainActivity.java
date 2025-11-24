package com.example.listacompra;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements RvAdapter.OnItemClickListener {


    private ArrayList<Item> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        items = DataItem.getItems();

        RecyclerView rc = findViewById(R.id.rvItems);
        rc.setHasFixedSize(true);
        rc.setLayoutManager(new LinearLayoutManager(this));

        RvAdapter mAdapter = new RvAdapter(this, items, this);
        rc.setAdapter(mAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);

        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
       if(item.getItemId()== R.id.optOpc1){
           Toast.makeText(MainActivity.this, "opcio1", Toast.LENGTH_SHORT).show();
       }
        return true;
    }

    @Override
    public void onItemClick(int position) {
        Item seleccionado = items.get(position);
        Toast.makeText(this, seleccionado.getNombre(), Toast.LENGTH_SHORT).show();

        Bundle b = new Bundle();
        b.putString("nombre", seleccionado.getNombre());
        b.putString("tipo", seleccionado.getTipo());
        b.putString("cantidad", String.valueOf(seleccionado.getCantidad()));
        b.putString("categoria", seleccionado.getCategoria());
        b.putString("InfoCategoria", seleccionado.getInfoCategoria());
        b.putString("url", seleccionado.getUrl());
        b.putInt("imagen", seleccionado.getImageResId());



        Intent i = new Intent(MainActivity.this, MostInfo.class);
        i.putExtras(b);
        startActivity(i);
    }


    }

