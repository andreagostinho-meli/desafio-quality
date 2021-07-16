package br.com.meli.desafioquality.dto.property.create;

import br.com.meli.desafioquality.dto.property.RoomRequestDTO;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

public class CreatePropertyRequestDTO {
    @NotBlank(message = "O nome da propriedade não pode estar vazio")
    @Pattern(regexp = "^[A-Z].*", message = "O nome da propriedade deve começar com uma letra maiúscula")
    @Size(max = 30, message = "O comprimento do nome não pode exceder 30 caracteres")
    private String prop_name;

    @NotNull(message = "O ID do bairro não pode ser vazio")
    private int prop_district_id;

    private List<RoomRequestDTO> rooms;

    public CreatePropertyRequestDTO() {
    }

    public String getProp_name() {
        return prop_name;
    }

    public void setProp_name(String prop_name) {
        this.prop_name = prop_name;
    }

    public int getProp_district_id() {
        return prop_district_id;
    }

    public void setProp_district_id(int prop_district_id) {
        this.prop_district_id = prop_district_id;
    }

    public List<RoomRequestDTO> getRooms() {
        return rooms;
    }

    public void setRooms(List<RoomRequestDTO> rooms) {
        this.rooms = rooms;
    }
}
