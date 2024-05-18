package org.example.Modelo;

import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

public abstract class Persona {

//Atributos
    private String nombre;
    private String apellido;
    private String  DNI;
    private String sexo;
    private Double peso;
    private Double altura;
    private Date fechaDeNacimiento;

    //Constructor

    public Persona(String nombre, String apellido, String DNI, String sexo, Double peso, Double altura, Date fechaDeNacimiento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.DNI = DNI;
        this.sexo = sexo;
        this.peso = peso;
        this.altura = altura;
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    //Getters Y Setters

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getDNI() {
        return DNI;
    }

    public String getSexo() {
        return sexo;
    }

    public Double getPeso() {
        return peso;
    }

    public Double getAltura() {
        return altura;
    }

    public Date getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }


    //Metodos
     public int calcularEdad()
     {
         Date fechaActual = new Date();
         LocalDate fechaNacimientoLocalDate = LocalDate.ofInstant(getFechaDeNacimiento().toInstant(), java.time.ZoneId.systemDefault());
         LocalDate fechaActualLocalDate = LocalDate.ofInstant(fechaActual.toInstant(), java.time.ZoneId.systemDefault());
        int edad = Period.between(fechaNacimientoLocalDate, fechaActualLocalDate).getYears();

         return edad;
     }
}
