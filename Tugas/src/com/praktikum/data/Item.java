package com.praktikum.data;

public class Item {
    private String itemnama;
    private String deskripsi;
    private String location;
    private String status;

    public Item(String itemnama, String deskripsi, String location){
        this.itemnama = itemnama;
        this.deskripsi = deskripsi;
        this.location = location;
        this. status = "Reported";
    }

    public String getItemnama() {
        return itemnama;
    }

    public void setItemnama(String itemnama) {
        this.itemnama = itemnama;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
