package br.com.meli.desafioquality.dto.property;

import javax.validation.constraints.*;

public class RoomRequestDTO {

    @NotBlank(message = "O nome do cômodo não pode estar vazio")
    @Pattern(regexp = "^[A-Z].*", message = "O nome do cômodo deve começar com uma letra maiúscula")
    @Size(max = 30, message = "O comprimento do cômodo não pode exceder 30 caracteres")
    private String room_name;

    @NotNull(message = "A largura do cômodo não pode estar vazia")
    @Max(value = 25, message = "A largura máxima permitida por cômodo é de 25 metros")
    private double room_width;

    @NotNull(message = "O comprimento do cômodo não pode estar vazio")
    @Max(value = 33, message = "O comprimento máximo permitido por cômodo é de 33 metros")
    private double room_length;

    public RoomRequestDTO() {
    }

    public String getRoom_name() {
        return room_name;
    }

    public void setRoom_name(String room_name) {
        this.room_name = room_name;
    }

    public double getRoom_width() {
        return room_width;
    }

    public void setRoom_width(double room_width) {
        this.room_width = room_width;
    }

    public double getRoom_length() {
        return room_length;
    }

    public void setRoom_length(double room_length) {
        this.room_length = room_length;
    }

}
