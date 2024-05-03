package com.example.galeriaimagenesrv;

public class Item {
    private String url;
    private String descripcion;

    public Item(String descripcion, String url) {
        this.descripcion = descripcion;
        this.url = url;

    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
