package org.example.Modelo;

import java.util.Objects;

public class Ejercicio {
    //atributos

    private String tipoDeEjercicio; //cardio, empuje, traccion
    private String nombreEjercicio; //ej: curl de bicep
    private String grupoMuscular; //hombros,piernas,core,brazos,espalda,pecho
    private String complejidad; //facil,medio,dificil
    private String materialDeTrabajo; //barra,mancuerna,peso libre,maquina,kettlebell,polea,bandas

    private int repeticiones;
    private int series;
    //constructores


    /*
    public Ejercicio()
    {
        tipoDeEjercicio="Sin tipo de ejercicio";
        nombreEjercicio="Sin nombre ejercicio";
        grupoMuscular="Sin grupo muscular";
        complejidad="Sin complejidad";
        materialDeTrabajo="Sin material de trabajo";
        repeticiones=-1;
        series=-1;
    }

     */

    /*
    public Ejercicio(String tipoDeEjercicio, String nombreEjercicio, String grupoMuscular, String complejidad, String materialDeTrabajo, int repeticiones, int series) {
        this.tipoDeEjercicio = tipoDeEjercicio;
        this.nombreEjercicio = nombreEjercicio;
        this.grupoMuscular = grupoMuscular;
        this.complejidad = complejidad;
        this.materialDeTrabajo = materialDeTrabajo;
        this.repeticiones = repeticiones;
        this.series = series;
    }

     */


    //get y set

    public String getTipoDeEjercicio() {
        return tipoDeEjercicio;
    }

    public String getNombreEjercicio() {
        return nombreEjercicio;
    }

    public String getGrupoMuscular() {
        return grupoMuscular;
    }

    public String getComplejidad() {
        return complejidad;
    }

    public String getMaterialDeTrabajo() {
        return materialDeTrabajo;
    }

    public int getRepeticiones() {
        return repeticiones;
    }

    public int getSeries() {
        return series;
    }

    public void setTipoDeEjercicio(String tipoDeEjercicio) {
        this.tipoDeEjercicio = tipoDeEjercicio;
    }

    public void setNombreEjercicio(String nombreEjercicio) {
        this.nombreEjercicio = nombreEjercicio;
    }

    public void setGrupoMuscular(String grupoMuscular) {
        this.grupoMuscular = grupoMuscular;
    }

    public void setComplejidad(String complejidad) {
        this.complejidad = complejidad;
    }

    public void setMaterialDeTrabajo(String materialDeTrabajo) {
        this.materialDeTrabajo = materialDeTrabajo;
    }

    public void setRepeticiones(int repeticiones) {
        this.repeticiones = repeticiones;
    }

    public void setSeries(int series) {
        this.series = series;
    }


    //metodos


    @Override
    public boolean equals(Object o) {
        boolean rta = false;

        if(o != null)
        {
            if(o instanceof Ejercicio aComparar)
            {
                if(this.getTipoDeEjercicio().equalsIgnoreCase(aComparar.getTipoDeEjercicio()) && this.getNombreEjercicio().equalsIgnoreCase(aComparar.getNombreEjercicio()))
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
        return "Ejercicio{" +
                "tipoDeEjercicio='" + tipoDeEjercicio + '\'' +
                ", nombreEjercicio='" + nombreEjercicio + '\'' +
                ", grupoMuscular='" + grupoMuscular + '\'' +
                ", complejidad='" + complejidad + '\'' +
                ", materialDeTrabajo='" + materialDeTrabajo + '\'' +
                ", repeticiones=" + repeticiones +
                ", series=" + series +"\n"+
                '}';
    }
}
