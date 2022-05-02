package com.example.apirestpersistencia.Model.entitats;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UsuariConsultaDTO {
    private String username;
    private String rol;
}