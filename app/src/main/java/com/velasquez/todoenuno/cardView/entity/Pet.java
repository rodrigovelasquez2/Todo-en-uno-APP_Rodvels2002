package com.velasquez.todoenuno.cardView.entity;

public class Pet {
    private int imagen;
    private String petsName;
    private String numeroIdentidad;
    private String descripcion;
    private String raza;
    private String edad;
    private String genero;
    private String color;

    public Pet() {
    }//Fin Pet

    public Pet(int imagen, String petsName, String numeroIdentidad, String descripcion, String raza, String edad, String genero, String color) {
        this.imagen = imagen;
        this.petsName = petsName;
        this.numeroIdentidad = numeroIdentidad;
        this.descripcion = descripcion;
        this.raza = raza;
        this.edad = edad;
        this.genero = genero;
        this.color = color;
    }//Fin Pet

    //Get and set:


    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public String getPetsName() {
        return petsName;
    }

    public void setPetsName(String petsName) {
        this.petsName = petsName;
    }

    public String getNumeroIdentidad() {
        return numeroIdentidad;
    }

    public void setNumeroIdentidad(String numeroIdentidad) {
        this.numeroIdentidad = numeroIdentidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}//Fin Pet
