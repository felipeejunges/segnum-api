package br.com.segnum.api.dto.user;

import javax.validation.constraints.NotEmpty;

public class ChangeProfileDTO {

    @NotEmpty(message="Preenchimento obrigatório")
    private int profileId;

    public ChangeProfileDTO() {
    }

    public ChangeProfileDTO(int profileId) {
        this.profileId = profileId;
    }

    public int getProfileId() {
        return profileId;
    }

    public void setProfileId(int profileId) {
        this.profileId = profileId;
    }
}
