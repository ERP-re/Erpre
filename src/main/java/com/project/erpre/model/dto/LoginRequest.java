package com.project.erpre.model.dto;

import lombok.*;

@Data
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
