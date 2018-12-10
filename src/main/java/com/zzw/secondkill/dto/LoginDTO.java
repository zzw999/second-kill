package com.zzw.secondkill.dto;

import com.zzw.secondkill.validator.IsMobile;
import lombok.Data;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

@Data
@ToString
public class LoginDTO {

    @NotNull
    @IsMobile
    private String mobile;

    @NotNull
    @Length(min=32)
    private String password;

}
