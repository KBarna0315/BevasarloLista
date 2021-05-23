package com.example.bevasarlolista.model;

public class OsszesKategoriaModel {

    Integer id;
    int imageurl;

    public OsszesKategoriaModel(Integer id, int imageurl) {
        this.id = id;
        this.imageurl = imageurl;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getImageurl() {
        return imageurl;
    }

    public void setImageurl(Integer imageurl) {
        this.imageurl = imageurl;
    }
}
