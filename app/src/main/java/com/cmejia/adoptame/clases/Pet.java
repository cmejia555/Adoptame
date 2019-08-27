package com.cmejia.adoptame.clases;

import android.graphics.drawable.Drawable;

public class Pet {

    private String name;
    private String age;
    private Drawable image;

    public Pet(String name, String age, Drawable image) {
        this.name = name;
        this.age = age;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public Drawable getImage() {
        return image;
    }

    public void setImage(Drawable image) {
        this.image = image;
    }

}
