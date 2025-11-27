package com.example.listacompra;

public class MemoryCard {
    private int imageResId;
    private boolean isFlipped;
    private boolean isMatched;

    public MemoryCard (int imageResId){
        this.imageResId = imageResId;
        this.isFlipped = false;
        this.isMatched = false;
    }
    public MemoryCard(){

    }

    public int getImageResId() {
        return imageResId;
    }

    public void setImageResId(int imageResId) {
        this.imageResId = imageResId;
    }

    public boolean isFlipped() {
        return isFlipped;
    }

    public void setFlipped(boolean flipped) {
        isFlipped = flipped;
    }

    public boolean isMatched() {
        return isMatched;
    }

    public void setMatched(boolean matched) {
        isMatched = matched;
    }
}
