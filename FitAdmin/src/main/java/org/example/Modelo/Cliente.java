package org.example.Modelo;

import org.example.Enum.EDiasSemana;
import org.example.Enum.ESexo;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class Cliente extends Persona implements Serializable {

    //Metodos
    private int idCliente;
    private String eMail;
    private boolean cuotaPagada;
    private boolean estado;
    private LinkedHashMap<String, Rutina> rutinaSemanal;
    private HashSet<String> actividadesInscripto;
    private boolean tieneFotoPerfil;

    private LocalDate fechaVencimientoCuota;


    //Constructor


    //cliente con id
    public Cliente(String nombre, String apellido, String DNI, ESexo sexo, Double peso, Double altura, LocalDate fechaDeNacimiento, String eMail, boolean cuotaPagada) {
        super(nombre, apellido, DNI, sexo, peso, altura, fechaDeNacimiento);
        this.idCliente = 0;
        this.eMail = eMail;
        this.cuotaPagada = cuotaPagada;
        this.estado = true; //cuando se crea el cliente el estado siempre es true
        tieneFotoPerfil=false;
        fechaVencimientoCuota= LocalDate.now().plusDays(30);

        setRutinaSemanal();
        actividadesInscripto = new HashSet<>();
    }

    //Getters y Setters


    public void setRutinaSemanal() {
        //metodo para inicializar todos los dias con una rutina vacia, y q no haya nullpointers
        rutinaSemanal = new LinkedHashMap<>();
        rutinaSemanal.put(EDiasSemana.LUNES.toString(),new Rutina(EDiasSemana.LUNES));
        rutinaSemanal.put(EDiasSemana.MARTES.toString(),new Rutina(EDiasSemana.MARTES));
        rutinaSemanal.put(EDiasSemana.MIERCOLES.toString(),new Rutina(EDiasSemana.MIERCOLES));
        rutinaSemanal.put(EDiasSemana.JUEVES.toString(),new Rutina(EDiasSemana.JUEVES));
        rutinaSemanal.put(EDiasSemana.VIERNES.toString(),new Rutina(EDiasSemana.VIERNES));
        rutinaSemanal.put(EDiasSemana.SABADO.toString(),new Rutina(EDiasSemana.SABADO));
        rutinaSemanal.put(EDiasSemana.DOMINGO.toString(),new Rutina(EDiasSemana.DOMINGO));

    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String geteMail() {
        return eMail;
    }

    public boolean isCuotaPagada() {
        boolean flag=false;

        if (cantDiasRestantesCuota() >= 0) // si es 0 la tiene que pagar maniana
        {
            flag=true;
        }

        return flag;
    }

    public void setCuotaPagada(boolean cuotaPagada) {
        this.cuotaPagada = cuotaPagada;
    }

    public boolean isEstado() {
        return estado;
    }

    public boolean isTieneFotoPerfil() {
        return tieneFotoPerfil;
    }

    public LinkedHashMap<String, Rutina> getRutinaSemanal() {
        return rutinaSemanal;
    }

    public HashSet<String> getActividadesInscripto() {
        return actividadesInscripto;
    }

    public void agregarActividadACliente(String actividadesInscripto) {
        this.actividadesInscripto.add(actividadesInscripto);
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public void setTieneFotoPerfil(boolean tieneFotoPerfil) {
        this.tieneFotoPerfil = tieneFotoPerfil;
    }

    //Metodos

    public String pagarCuotaCliente()
    {
        String mensaje="";
        System.out.println(isCuotaPagada());
        if (isCuotaPagada())
        {
            System.out.println(isEstado());
            if (isEstado())
            {
                //tambien tengo que obtener el changui que queda si el cliente me paga antes del vencimiento

                int difDeDias= cantDiasRestantesCuota();
                int unaCuota=30;
                System.out.println("Diferencia de dias: "+ difDeDias);
                if (difDeDias >= 0) //si mi diferencia de dias es positiva, significa que me estas pagando antes
                {
                    //por lo tanto, le agrego una cuota(que son 30 dias)
                    //no agrego la dif de dias, ya que no es necesario, si se me vence en 9 dias la cuota y me la paga antes, le sumo una cuota (30 dias) y mi nueva fecha de vencimiento seria en 39 dias
                    fechaVencimientoCuota= fechaVencimientoCuota.plusDays(unaCuota);
                    // System.out.println("Fecha de venc: "+ fechaVencimientoCuota);
                }
                else {
                    //si la diferencia es negativa, signifca que me esta debiendo cuota(Alto rata). Por lo tanto hago:
                    //le resto los dias que NO me pago a unaCuota(que son 30 dias)
                    fechaVencimientoCuota= fechaVencimientoCuota.plusDays(unaCuota+difDeDias);
                }
                // System.out.println("Nueva fecha de venc: "+fechaVencimientoCuota);
                setCuotaPagada(true);
                mensaje="Cuota pagada con exito";
            }
            else {
                mensaje="El cliente esta archivado";
            }
        }
        else {
            mensaje="Cuota ya esta pagada";
        }
        return mensaje;
    }

    public int cantDiasRestantesCuota()
    {
        LocalDate fechaActual= LocalDate.now();
//        System.out.println(fechaActual);
//        System.out.println(fechaVencimientoCuota);
        int data= Math.toIntExact(ChronoUnit.DAYS.between(fechaActual, fechaVencimientoCuota));
       // System.out.println(Integer.parseInt(String.valueOf(data)));
        System.out.println(data);
        return data; //obtengo la cantidad de dias que le quedan a la cuota del cliente
    }

    public boolean estaLaCuotaVencida()
    {
        boolean flag=false;

        if (cantDiasRestantesCuota() < 0)
        {
            flag=true;
        }

        return flag;
    }

    //Esta funcion me va a servir para ordenar por dias y luego imprimir el PDF correctamente
    public String formatearDatosCliente(Cliente cliente)
    {
        String msj = "";
        if(cliente!= null)
        {
            msj +="Numero de socio: "+ cliente.getIdCliente()+"\n";
            msj +="Nombre: "+ cliente.getNombre()+"\n";
            msj +="Apellido: "+ cliente.getApellido()+"\n";
            msj +="DNI: "+ cliente.getDNI()+"\n";
            msj +="E-Mail: "+ cliente.geteMail()+"\n";
            msj +="Sexo: "+ cliente.getSexo()+"\n";
            msj +="Edad: "+ cliente.getEdad()+"\n";
            msj +="Fecha de nacimiento: "+ cliente.getFechaDeNacimiento()+"\n";
            msj +="Peso: "+ cliente.getPeso()+"\n";
            msj +="Altura: "+ cliente.getAltura()+"\n";
            msj +="Actividades en las que se encuentra inscripto: "+ cliente.getActividadesInscripto()+"\n";
        }

        return msj;
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return 1;
    }

    public Rutina getUnaRutinaEspecifica(Enum diaRequerido)
    {
        return rutinaSemanal.get(diaRequerido.toString());
    }

    public void modificarNombreCliente(String nombre){
        if(nombre != null){
            setNombre(nombre);
        }
    }
    public void modificarApellidoCliente(String apellido){
        if(apellido != null){
            setApellido(apellido);
        }
    }
    public void modificarEMailCliente(String eMail){
        if(eMail != null){
            seteMail(eMail);
        }
    }
    public void modificarDNICliente(String DNI){
        if(DNI != null){
            setDNI(DNI);
        }
    }

    public void modificarPesoCliente(Double peso){
        if(peso != null){
            setPeso(peso);
        }
    }
    public void modificarAlturaCliente(Double altura){
        if(altura!= null){
            setAltura(altura);
        }
    }

    public void modificarCuotaCliente(){
        if(cuotaPagada){
            setCuotaPagada(false);
        }else {
            setCuotaPagada(true);
        }
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "actividadesInscripto=" + actividadesInscripto +
                ", idCliente=" + idCliente +
                ", eMail='" + eMail + '\'' +
                ", cuotaPagada=" + cuotaPagada +
                ", estado=" + estado +
                ", rutinaSemanal=" + rutinaSemanal +
                ", tieneFotoPerfil=" + tieneFotoPerfil +
                '}'+super.toString();
    }

    public String listarActividades()//metodo para que no tener corchetes en la GUI
    {
        String msj ="";
            Iterator iterator = actividadesInscripto.iterator();
            while(iterator.hasNext())
            {
                msj+= iterator.next();
            }

        return msj;
    }
}



