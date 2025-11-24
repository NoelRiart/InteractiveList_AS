package com.example.listacompra;

import androidx.appcompat.app.AppCompatActivity;

public class Item extends AppCompatActivity {

    private String nombre;
    private String tipo;
    private String cantidad;
    private String categoria;
    private String InfoCategoria;
    private String url;
    private int imageResId;

    public Item(String nombre, String tipo, String cantidad, String categoria, String InfoCategoria, String url, int imageResId) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.cantidad = cantidad;
        this.categoria = categoria;
        this.InfoCategoria = InfoCategoria;
        this.url = url;
        this.imageResId = imageResId;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getImageResId() {
        return imageResId;
    }

    public void setImageResId(int imageResId) {
        this.imageResId = imageResId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getInfoCategoria() {
        return InfoCategoria;
    }

    public void setInfoCategoria(String infoCategoria) {
        InfoCategoria = infoCategoria;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

