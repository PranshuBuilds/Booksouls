package com.crazy.booksoul.preference;

import android.graphics.drawable.Drawable;

public class prefrence {

    String tag; int image;

    prefrence(){

    }
    prefrence(String tag, int image){
        this.tag=tag;
        this.image=image;

    }



    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
