package com.ddimitko.boriclima.DTO.User;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserCreationDto {

    @NotNull
    @Email
    private String email;

    @NotNull
    @Size(min = 8)
    private String password;

    private String firstName;
    private String lastName;


}
