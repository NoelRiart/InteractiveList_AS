package com.example.listacompra;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RvAdapter extends RecyclerView.Adapter<RvAdapter.MyViewHolder> {

    private final ArrayList<Item> lista;
    private final LayoutInflater mInflater;
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    //  principal
    public RvAdapter(Context context, ArrayList<Item> lista, OnItemClickListener listener) {
        this.mInflater = LayoutInflater.from(context);
        this.lista = lista;
        this.listener = listener;
    }

    public Item getItem(int position) {
        return lista.get(position);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.elementsllista, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Item it = lista.get(position);
        holder.tvNombre.setText(it.getNombre());
        holder.tvTipo.setText(it.getTipo());
        holder.tvCantidad.setText(it.getCantidad());
        holder.tvCategoria.setText(it.getCategoria());
        holder.imagen.setImageResource(it.getImageResId());
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imagen;
        TextView tvNombre, tvTipo, tvCantidad, tvCategoria;
        private ArrayList<Item> items;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imagen = itemView.findViewById(R.id.imgProducto);
            tvNombre = itemView.findViewById(R.id.tvNombre);
            tvTipo = itemView.findViewById(R.id.tvTipo);
            tvCantidad = itemView.findViewById(R.id.tvCantidad);
            tvCategoria = itemView.findViewById(R.id.tvCategoria);

            itemView.setOnClickListener(v -> {
                if (listener != null) {
                    int pos = getAdapterPosition();
                    if (pos != RecyclerView.NO_POSITION) {
                        listener.onItemClick(pos);
                    }
                }
            });
        }
        public void updateList(ArrayList<Item> nuevaLista) {
            this.items = nuevaLista;
            notifyDataSetChanged();
        }

    }
}
