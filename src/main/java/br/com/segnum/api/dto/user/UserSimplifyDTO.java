package br.com.segnum.api.dto.user;

import br.com.segnum.api.domain.User;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

public class UserSimplifyDTO {

    @NotEmpty(message="Preenchimento obrigatório")
    private int id;
    @NotEmpty(message="Preenchimento obrigatório")
    private String name;

    public UserSimplifyDTO() {
    }

    public UserSimplifyDTO(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public UserSimplifyDTO(User user) {
        this.id = user.getId();
        this.name = user.getName();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
