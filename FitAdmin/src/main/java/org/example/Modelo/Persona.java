package org.example.Modelo;

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

    //Metodos
}
