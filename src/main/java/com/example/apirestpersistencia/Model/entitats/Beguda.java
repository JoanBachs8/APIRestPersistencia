package com.example.apirestpersistencia.Model.entitats;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Beguda {
    @Id
    private String id;
    private String tipus;
    private double preu;
}
