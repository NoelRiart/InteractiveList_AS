package com.example.listacompra;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.widget.GridLayout;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collections;

public class Juego extends AppCompatActivity {

    private GridLayout gridLayout;
    private ArrayList<MemoryCard> cards = new ArrayList<>();
    private ArrayList<ImageButton> buttons = new ArrayList<>();

    private MemoryCard firstCard = null;
    private boolean isBusy = false;

    private static final int NUM_CARDS = 16;  // 4x4 tablero
    private static final int PAIR_COUNT = 8;  // 8 imágenes diferentes



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.juego);

        gridLayout = findViewById(R.id.gridJuego);

        ArrayList<Integer> images = cargarImagenes();
        prepararCartas(images);
        crearTablero();
    }


    private ArrayList<Integer> cargarImagenes() {

        int[] imgs = {
                R.drawable.pomavermella,
                R.drawable.pomaverda,
                R.drawable.platano,
                R.drawable.lechuga,
                R.drawable.tomate,
                R.drawable.carnepicada,
                R.drawable.zanahoria,
                R.drawable.pollo
        };

        ArrayList<Integer> lista = new ArrayList<>();
        for (int res : imgs) lista.add(res);

        return lista;
    }


    private void prepararCartas(ArrayList<Integer> images) {

        ArrayList<Integer> baraja = new ArrayList<>();

        // Duplica cada imagen (2 de cada)
        for (int img : images) {
            baraja.add(img);
            baraja.add(img);
        }

        // Baraja aleatoriamente
        Collections.shuffle(baraja);

        // Crea MemoryCards
        for (int img : baraja) {
            cards.add(new MemoryCard(img));
        }
    }


    private void crearTablero() {

        for (int i = 0; i < NUM_CARDS; i++) {

            ImageButton btn = new ImageButton(this);

            // Tamaño dinámico proporcional
            GridLayout.LayoutParams params = new GridLayout.LayoutParams();
            params.width = 0;
            params.height = 0;
            params.columnSpec = GridLayout.spec(GridLayout.UNDEFINED, 1f);
            params.rowSpec = GridLayout.spec(GridLayout.UNDEFINED, 1f);
            btn.setLayoutParams(params);

            btn.setScaleType(ImageButton.ScaleType.CENTER_CROP);
            btn.setBackgroundColor(Color.TRANSPARENT);
            btn.setImageResource(R.drawable.card_back);

            final int index = i;
            btn.setOnClickListener(v -> onCardClicked(index));

            buttons.add(btn);
            gridLayout.addView(btn);
        }
    }


    private void onCardClicked(int index) {

        if (isBusy) return;

        MemoryCard card = cards.get(index);
        ImageButton btn = buttons.get(index);

        if (card.isMatched() || card.isFlipped()) return;

        btn.setImageResource(card.getImageResId());
        card.setFlipped(true);

        if (firstCard == null) {
            firstCard = card;
        } else {
            isBusy = true;

            new Handler().postDelayed(() -> {
                comprobarPareja(firstCard, card);
                firstCard = null;
                isBusy = false;
            }, 700);
        }
    }


    private void comprobarPareja(MemoryCard c1, MemoryCard c2) {

        int i1 = cards.indexOf(c1);
        int i2 = cards.indexOf(c2);

        if (c1.getImageResId() == c2.getImageResId()) {

            c1.setMatched(true);
            c2.setMatched(true);

        } else {
            c1.setFlipped(false);
            c2.setFlipped(false);

            buttons.get(i1).setImageResource(R.drawable.card_back);
            buttons.get(i2).setImageResource(R.drawable.card_back);
        }
    }
}