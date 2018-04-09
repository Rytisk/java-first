package com.jlab.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Currency;

@Entity
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "COST")
    private Currency cost;

}
