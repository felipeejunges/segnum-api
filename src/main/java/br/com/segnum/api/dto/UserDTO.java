package br.com.segnum.api.dto;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

public class UserDTO {

    @NotEmpty(message="Preenchimento obrigatório")
    @Length(min=5, max=80, message="O tamanho deve ser entre 5 e 80 caracteres")
    private String name;
    @NotEmpty(message="E-mail inválido")
    @Email
    private String email;
    private String phone;
    private Date birthday;
    @NotEmpty(message="Preenchimento obrigatório")
    private String password;

    public UserDTO() {
    }

    public UserDTO(String name, String email, String phone, Date birthday, String password) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.birthday = birthday;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
