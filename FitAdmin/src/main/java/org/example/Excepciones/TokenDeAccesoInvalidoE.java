package org.example.Excepciones;

public class TokenDeAccesoInvalidoE extends Exception{

    //constructores

    public TokenDeAccesoInvalidoE() {
        super();
    }

    public TokenDeAccesoInvalidoE(String message) {
        super(message);
    }

    //metodos


    @Override
    public String getMessage() {
        return this.toString();
    }

    @Override
    public String toString() {
        return "ERROR: Token sin autenticar";
    }
}
