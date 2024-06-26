package org.example.Modelo;

public abstract class Actividad {
    //atributos

    //si hay tiempo agregar atributo precio y sus funcionalidades al igual que Dates
    /*
    private double precio;
    private Calendar fechaInicio;
    private Calendar fechaVencimiento;
    private String modalidadDePago;
    */
    private int cupos;
//todo si se crea una actividad la 1er letra es mayuscula y lo demas en miniscula sino no va a funcionar en la GUI

    //constructores

    public Actividad()
    {
        cupos=0;
    }

    public Actividad(int cupos) {
        this.cupos = cupos;
    }

    //get y set

    public int getCupos() {
        return cupos;
    }

    public void setCupos(int cupos) {
        this.cupos = cupos;
    }

    //metodos

    public abstract String obtenerNombreActividad();
    //public abstract double calcularPrecioDeUnaClase();
    //public abstract double calcularPrecioCuota();
}
