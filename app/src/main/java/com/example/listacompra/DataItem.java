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
        items.add(new Item("Zanahoria", "Naranja", "3 ud", "Verdura", "Rica en vitamina A y betacarotenos.", "https://es.wikipedia.org/wiki/Zanahoria", R.drawable.zanahoria));

        items.add(new Item("Carne", "Picada", "500 gr", "Carne","Alto contenido en proteínas.", "https://es.wikipedia.org/wiki/Mincemeat",R.drawable.carnepicada));
        items.add(new Item("Albóndigas", "Mixta", "12 ud", "Carne", "Alto contenido en proteínas. Generalmente elaboradas con carne picada.", "https://es.wikipedia.org/wiki/Alb%C3%B3ndiga", R.drawable.albondigas));
        items.add(new Item("Chuleta", "Cerdo", "2 ud", "Carne", "Corte con hueso rico en proteínas y minerales.", "https://es.wikipedia.org/wiki/Chuleta", R.drawable.chuleta));
        items.add(new Item("Pollo", "Entero", "1 ud", "Carne", "Fuente de proteínas ", "https://es.wikipedia.org/wiki/Carne_de_pollo", R.drawable.pollo));




        return items;
    }
}
