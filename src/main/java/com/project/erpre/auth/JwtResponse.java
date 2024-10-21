package com.project.erpre.auth;

import lombok.*;

import java.util.Date;

@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class JwtResponse {
    private String token;
    private Date issuedAt;
    private Date expiration;

}
