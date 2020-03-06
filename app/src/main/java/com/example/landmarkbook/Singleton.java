package com.example.landmarkbook;

import android.graphics.Bitmap;

public class Singleton {
    private Bitmap selectedItem;
    private static Singleton singleton;
    public Bitmap getSelectedItem() {
        return selectedItem;
    }

    public void setSelectedItem(Bitmap selectedItem) {
        this.selectedItem = selectedItem;
    }

    public Singleton(){

    }

    public static Singleton getInstance(){
        if (singleton==null){
            singleton=new Singleton();
        }
        return singleton;
    }
}
