package com.project.erpre.auth;

import lombok.*;

@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequest {
    private String employeeId;
    private String employeePw;
}
