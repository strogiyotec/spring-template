package com.template.controller.input;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public final class RegisterUserRequest {

    @NotBlank(message = "Username is mandatory!")
    @Size(max = 50, message = "Username is too long!")
    private String username;

    @NotBlank(message = "Email is mandatory!")
    @Size(max = 100, message = "Email is too long!")
    @Email(message = "Invalid email!")
    private String email;

    @NotBlank(message = "Password is mandatory!")
    @Size(max = 100, min = 10)
    private String password;

    @NotBlank(message = "Name is mandatory!")
    @Size(max = 50, message = "Name is too long!")
    private String name;

    @NotBlank(message = "Surname is mandatory!")
    @Size(max = 50, message = "Surname is too long!")
    private String surname;
}
