package com.example.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import lombok.Data;

@Data
public class signupForm {

    @NotBlank(groups = ValidGroup1.class)
    private String userId;

    @NotBlank(groups = ValidGroup1.class)
    @Length(min = 6, max = 8, groups = ValidGroup2.class)
    @Pattern(regexp="^[a-zA-Z0-9]+$",groups=ValidGroup2.class)
    private String password;

    @NotBlank(groups = ValidGroup1.class)
    private String userName;

}
