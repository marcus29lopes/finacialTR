package com.app.financialTR.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequestDTO {

    @NotBlank(message = "O email é obrigatorio")
    @Email(message = "Formato de email invalido")
    private String dsEmail;

    @NotBlank(message = "A senha é obrigatória")
    private String dsPassword;
}
