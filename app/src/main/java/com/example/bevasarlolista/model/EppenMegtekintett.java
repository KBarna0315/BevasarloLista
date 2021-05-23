package com.example.bevasarlolista.model;

import android.graphics.drawable.Drawable;

public class EppenMegtekintett {
    String nev;
    String leiras;
    String ar;
    String mennyiseg;
    String egysegar;
    Integer imageURL;

    Integer bgimageurl; //Új attributum

    //Kedvencem a Generate Constructor
    public EppenMegtekintett(String nev, String leiras, String ar, String mennyiseg, String egysegar, Integer imageURL,Integer bgimageurl) {
        this.nev = nev;
        this.leiras = leiras;
        this.ar = ar;
        this.mennyiseg = mennyiseg;
        this.egysegar = egysegar;
        this.imageURL = imageURL;
        this.bgimageurl=bgimageurl; //Új attributum
    }

    //Kellene Getter-Setter

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public String getLeiras() {
        return leiras;
    }

    public void setLeiras(String leiras) {
        this.leiras = leiras;
    }

    public String getAr() {
        return ar;
    }

    public void setAr(String ar) {
        this.ar = ar;
    }

    public String getMennyiseg() {
        return mennyiseg;
    }

    public void setMennyiseg(String mennyiseg) {
        this.mennyiseg = mennyiseg;
    }

    public String getEgysegar() {
        return egysegar;
    }

    public void setEgysegar(String egysegar) {
        this.egysegar = egysegar;
    }

    public Integer getImageURL() {
        return imageURL;
    }

    public void setImageURL(Integer imageURL) {
        this.imageURL = imageURL;
    }

    public Integer getBgimageurl() {
        return bgimageurl;
    } //Új getter

    public void setBgimageurl(Integer imageURL) {
        this.bgimageurl = bgimageurl;
    } //Uj setter

}
