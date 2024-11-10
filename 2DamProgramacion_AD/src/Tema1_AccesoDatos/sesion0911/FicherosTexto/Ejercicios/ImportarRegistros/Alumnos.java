package Tema1_AccesoDatos.sesion0911.FicherosTexto.Ejercicios.ImportarRegistros;

public class Alumnos {
    // Atributos
    private String nombre;
    private int edad;
    private String ciclo;
    private double notaMedia;

    // Constructor parametrizado
    public Alumnos(String nombre, int edad, String ciclo, double notaMedia) {
        this.nombre = nombre;
        this.edad = edad;
        this.ciclo = ciclo;
        this.notaMedia = notaMedia;
    }

    // GETTER/SETTER

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCiclo() {
        return ciclo;
    }

    public void setCiclo(String ciclo) {
        this.ciclo = ciclo;
    }

    public double getNotaMedia() {
        return notaMedia;
    }

    public void setNotaMedia(double notaMedia) {
        this.notaMedia = notaMedia;
    }

    // Metodo toString()
    @Override
    public String toString() {
        return "Alumnos{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", ciclo='" + ciclo + '\'' +
                ", notaMedia=" + notaMedia +
                '}';
    }
}
