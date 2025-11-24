package com.example.listacompra;

import java.util.ArrayList;

public class DataItem {

    public static ArrayList<Item> getItems() {
        ArrayList<Item> items = new ArrayList<>();


        items.add(new Item("Manzanas", "Roja", "1 kg", "Fruta","Ricas en vitaminas (A, C), agua y fibra","https://es.wikipedia.org/wiki/Roja_(manzana)", R.drawable.pomavermella));
        items.add(new Item("Manzanas", "Verde", "2 kg", "Fruta","Ricas en vitaminas (A, C), agua y fibra", "https://es.wikipedia.org/wiki/Granny_Smith",R.drawable.pomaverda));
        items.add(new Item("Plátano", "Amarillo", "6 ud", "Fruta","Ricas en vitaminas (A, C), agua y fibra", "https://ca.wikipedia.org/wiki/Banana",R.drawable.platano));


        items.add(new Item("Lechuga", "Verde", "1 ud", "Verdura", "Vitaminas (A, C, K), minerales y fibra.","https://es.wikipedia.org/wiki/Lactuca_sativa", R.drawable.lechuga));
        items.add(new Item("Tomate", "Rojo", "1/2 kg", "Verdura","Vitaminas (A, C, K), minerales y fibra.", "https://es.wikipedia.org/wiki/Tomate",R.drawable.tomate));


        items.add(new Item("Carne", "Picada", "500 gr", "Carne","Alto contenido en proteínas.", "https://es.wikipedia.org/wiki/Mincemeat",R.drawable.carnepicada));

        return items;
    }
}
