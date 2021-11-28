package com.example.form;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class signupForm {

    @NotBlank(groups = ValidGroup1.class)
    private String userId;

    @NotBlank(groups = ValidGroup1.class)
    private String password;

    @NotBlank(groups = ValidGroup1.class)
    private String userName;

}
