package org.example.Excepciones;

public class MailSinArrobaE extends Exception{

    //constructores

    public MailSinArrobaE() {
        super();
    }

    public MailSinArrobaE(String message) {
        super(message);
    }

    //metodos


    @Override
    public String getMessage() {
        return this.toString();
    }

    @Override
    public String toString() {
        return "ERROR: Mail ingresado sin @ (Arroba)";
    }

}
