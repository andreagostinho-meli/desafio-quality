package br.com.meli.desafioquality.exceptions;

public class PropertyNotFoundException extends RuntimeException {
    public PropertyNotFoundException() {
        super("Propriedade não encontrada");
    }
}
