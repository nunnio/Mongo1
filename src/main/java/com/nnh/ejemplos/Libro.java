package com.nnh.ejemplos;// -cp /usr/share/java/mongo-java-driver.jar

import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.types.ObjectId;

import java.util.Date;

class Libro {

    public ObjectId id;
    private String titulo;
    private String descripcion;
    private String autor;
    private Date fecha;
    private boolean disponible;
//    private Editorial editorial;

    public Libro(String t, String d, String a, Date f, boolean disp) {
        id=new ObjectId();
        titulo=t; descripcion=d; autor=a; fecha=f; disponible=disp;
    }

    public Libro() {

    }
    public void setId(ObjectId id) { this.id = id; }

    @BsonId // anotación necesaria por ser el atributo id private
    public ObjectId getId() { return id; }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public boolean getDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

/*    public Editorial getEditorial() {
        return editorial;
    }

    public void setEditorial(Editorial editorial) {
        this.editorial = editorial;
    }*/
}
