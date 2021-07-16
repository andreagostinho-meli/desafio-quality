package br.com.meli.desafioquality.exceptions;

public class DistrictNotFoundException extends RuntimeException {
    public DistrictNotFoundException() {
        super("Bairro não encontrado");
    }
}
