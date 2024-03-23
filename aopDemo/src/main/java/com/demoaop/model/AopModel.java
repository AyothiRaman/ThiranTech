package com.demoaop.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Aop_Details")
public class AopModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String location;


}
