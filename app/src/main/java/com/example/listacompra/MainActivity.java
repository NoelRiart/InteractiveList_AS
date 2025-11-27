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

    RecyclerView rc;
    RvAdapter mAdapter;
    private ArrayList<Item> allItems = DataItem.getItems();

    private ArrayList<Item> visibleItems;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rc = findViewById(R.id.rvItems);
        rc.setHasFixedSize(true);
        rc.setLayoutManager(new LinearLayoutManager(this));

        visibleItems = allItems;
        createList(visibleItems);

    }

    public void createList(ArrayList<Item> i) {


        mAdapter = new RvAdapter(this, i, this);
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
        int id = item.getItemId();
        ArrayList<Item> listItem = new ArrayList<>();


        if (id == R.id.optFrutas) {
            for (Item i : allItems) {
                if (i.getCategoria().equals("Fruta")) {
                    listItem.add(i);

                }
            }
        } else if (id == R.id.optVerduras) {
            for (Item i : allItems) {
                if (i.getCategoria().equals("Verdura")) {
                    listItem.add(i);
                }
            }
        } else if (id == R.id.optCarns) {
            for (Item i : allItems) {
                if (i.getCategoria().equals("Carne")) {
                    listItem.add(i);
                }
            }
        } else if (id == R.id.optJoc) {
            Intent intent = new Intent(MainActivity.this, Juego.class);
            startActivity(intent);
            return true;

        } else if (id == R.id.optTodos) {
            listItem = allItems;
        } else return super.onOptionsItemSelected(item);


        visibleItems = listItem;
        createList(visibleItems);

        return true;
    }


    @Override
    public void onItemClick(int position) {
        Item seleccionado = visibleItems.get(position);
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

