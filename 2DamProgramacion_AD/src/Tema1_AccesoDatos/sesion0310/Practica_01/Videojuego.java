package Tema1_AccesoDatos.sesion0310.Practica_01;


import com.google.gson.Gson;


public class Videojuego {
    //Atributos
    private String titulo;
    private int lanzamiento;
    private String plataforma;
    private float precio;
    private String portada;

    //Constructor parametrizado

    public Videojuego(String titulo, int lanzamiento, String plataforma, float precio, String portada) {
        this.titulo = titulo;
        this.lanzamiento = lanzamiento;
        this.plataforma = plataforma;
        this.precio = precio;
        this.portada = portada;
    }


    //GETTER/SETTER

    public String getTitulo() {
        return titulo;
    }

    public int getLanzamiento() {
        return lanzamiento;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public float getPrecio() {
        return precio;
    }

    public String getPortada() {
        return portada;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setLanzamiento(int lanzamiento) {
        this.lanzamiento = lanzamiento;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public void setPortada(String portada) {
        this.portada = portada;
    }

    //Método toString()
    @Override
    public String toString() {
        return "Videojuego{" +
                "titulo='" + titulo + '\'' +
                ", lanzamiento=" + lanzamiento +
                ", plataforma='" + plataforma + '\'' +
                ", precio=" + precio +
                ", portada='" + portada + '\'' +
                '}';
    }
}
