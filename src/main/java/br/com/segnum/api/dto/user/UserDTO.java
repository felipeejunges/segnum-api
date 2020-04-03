package br.com.segnum.api.dto.user;

import br.com.segnum.api.domain.User;
import br.com.segnum.api.domain.enums.Profile;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class UserDTO {

    @NotEmpty(message="Preenchimento obrigatório")
    private int id;
    @NotEmpty(message="Preenchimento obrigatório")
    @Length(min=5, max=80, message="O tamanho deve ser entre 5 e 80 caracteres")
    private String name;
    @NotEmpty(message="E-mail inválido")
    @Email
    private String email;
    private String phone;
    private Date birthday;

    private List<ProfileDTO> profiles = new ArrayList<>();

    public UserDTO() {
    }

    public UserDTO(int id, String name, String email, String phone, Date birthday) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.birthday = birthday;
    }

    public UserDTO(int id, String name, String email, String phone, Date birthday, List<ProfileDTO> profiles) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.birthday = birthday;
        this.profiles = profiles;
    }

    public UserDTO(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.phone = user.getPhone();
        this.email = user.getEmail();
        this.birthday = user.getBirthday();
        this.profilesEnumToDto(user.getProfiles());
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

    public List<ProfileDTO> getProfiles() {
        return profiles;
    }

    public void setProfiles(List<ProfileDTO> profiles) {
        this.profiles = profiles;
    }

    public void profilesEnumToDto(Set<Profile> enumProfiles) {
        enumProfiles.forEach(p -> {
            this.profiles.add(new ProfileDTO(p.getCode(), p.getDescription()));
        });
    }
}
