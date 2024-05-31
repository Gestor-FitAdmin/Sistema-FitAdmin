package org.example.Modelo;

import org.example.Enum.EDiasSemana;
import org.example.Enum.ESexo;
import org.example.Excepciones.MailSinArrobaE;
import org.example.GUI.GUIEnvoltorio;

import javax.mail.MessagingException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Cliente extends Persona{

    //Metodos
    private int idCliente;
    private String eMail;
    private boolean cuotaPagada;
    private boolean estado;
    private LinkedHashMap<String, Rutina> rutinaSemanal;
    private HashSet<String> actividadesInscripto;

    //Constructor


    //cliente con id
    public Cliente(String nombre, String apellido, String DNI, ESexo sexo, Double peso, Double altura, LocalDate fechaDeNacimiento, String eMail, boolean cuotaPagada) {
        super(nombre, apellido, DNI, sexo, peso, altura, fechaDeNacimiento);
        this.idCliente = 0;
        this.eMail = eMail;
        this.cuotaPagada = cuotaPagada;
        this.estado = true; //cuando se crea el cliente el estado siempre es true

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
        return cuotaPagada;
    }

    public void setCuotaPagada(boolean cuotaPagada) {
        this.cuotaPagada = cuotaPagada;
    }

    public boolean isEstado() {
        return estado;
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


    //Metodos
    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return 1;
    }

//    public void asignarUnaRutinaAUnDia(Rutina nuevaRutina, EDiasSemana diaAsignado){
//        String stringDiaAsignado = diaAsignado.name(); //obtengo el valor del enum pero en formato String (lo parseo a un string)
//
//        rutinaSemanal.put(stringDiaAsignado,nuevaRutina);
//    }


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
    //todo cambiar rango a private
    public void verificarSiEsCumpleanos()
    {
        LocalDate fechaNacimiento = LocalDate.parse(getFechaDeNacimiento(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));

        int diaActual=LocalDate.now().getDayOfMonth(),mesActual=LocalDate.now().getMonthValue();
        int diaCliente= fechaNacimiento.getDayOfMonth(),mesCliente=fechaNacimiento.getMonthValue();

        String mensajeCumple="";
        int nuevaEdad=0;



        if (diaActual == diaCliente && mesActual == mesCliente)
        {
            nuevaEdad= calcularEdad();


            setEdad(nuevaEdad);


            mensajeCumple="Adminfit te desea un muy feliz cumpleaños. Felices "+getEdad()+" "+getNombre()+"!!!!!"+".Mas te vale que vengas ;)";
            try {
                GUIEnvoltorio.getGimnasio().enviarUnMail(geteMail(),mensajeCumple,false);
            } catch (MessagingException e) {
                e.printStackTrace();
            } catch (MailSinArrobaE e) {
                e.printStackTrace();
            }
        }

    }


    @Override
    public String toString() {
        return "Cliente{" +
                "idSocio=" + idCliente +
                ", eMail='" + eMail + '\'' +
                ", cuotaPagada=" + cuotaPagada +
                ", estado=" + estado +
                ", rutinaSemanal=" + rutinaSemanal +
                ", actividadesInscripto=" + actividadesInscripto +
                '}' + super.toString();
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



