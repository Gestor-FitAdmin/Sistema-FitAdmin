package org.example.Modelo;

import org.example.Enum.ESexo;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Objects;

public abstract class Persona implements Serializable {

//Atributos
    private String nombre;
    private String apellido;
    private String DNI;
    private ESexo sexo;
    private Double peso;
    private Double altura;
    private LocalDate fechaDeNacimiento;
    private int edad;

    //Constructor

    public Persona(String nombre, String apellido, String DNI, ESexo sexo, Double peso, Double altura, LocalDate fechaDeNacimiento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.DNI = DNI;
        this.sexo = sexo;
        this.peso = peso;
        this.altura = altura;
        this.fechaDeNacimiento = fechaDeNacimiento; //formateo string DD-MM-YYYY
        edad = calcularEdad();
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

    public ESexo getSexo() {
        return sexo;
    }

    public Double getPeso() {
        return peso;
    }

    public Double getAltura() {
        return altura;
    }

    public String getFechaDeNacimiento() {
        return fechaDeNacimiento.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    }

    public int getEdad() {
        return edad;
    }

    protected void setNombre(String nombre) {
        this.nombre = nombre;
    }

    protected void setApellido(String apellido) {
        this.apellido = apellido;
    }

    protected void setDNI(String DNI) {
        this.DNI = DNI;
    }

    protected void setPeso(Double peso) {
        this.peso = peso;
    }

    protected void setAltura(Double altura) {
        this.altura = altura;
    }

    protected void setFechaDeNacimiento(LocalDate fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    protected void setEdad(int edad) {
        this.edad = edad;
    }

    private void setSexo(ESexo sexo) {
        this.sexo = sexo;
    }

    //Metodos

// <<<<<<< ModificarPoP-UPS
//     public LocalDate formatearFechaALocalDate(String fecha)
//     {
//         DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//         return LocalDate.parse(fecha,formato);
//     }
// =======
//    private LocalDate formatearFechaALocalDate(LocalDate fecha)
//    {
//        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy");

//        return LocalDate.parse(fecha,formato);
//    }



     public int calcularEdad()
     {
         LocalDate fechaActual = LocalDate.now();

         return Period.between(fechaDeNacimiento, fechaActual).getYears();
     }

    @Override
    public boolean equals(Object o) {
        boolean rta = false;
        if(o != null)
        {
            if(o instanceof Persona aComparar)
            {
                if(this.DNI.equals(aComparar.getDNI()))
                {
                    rta = true;
                }

            }

        }
        return rta;
    }

    @Override
    public int hashCode() {
        return 1;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", DNI='" + DNI + '\'' +
                ", sexo='" + sexo + '\'' +
                ", peso=" + peso +
                ", altura=" + altura +
                ", fechaDeNacimiento=" + fechaDeNacimiento +
                ", edad=" + edad +
                '}';
    }
}
