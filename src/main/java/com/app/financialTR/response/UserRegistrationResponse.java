package com.app.financialTR.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class UserRegistrationResponse {
    private String dsEmail;
    private String nmUser;

}
