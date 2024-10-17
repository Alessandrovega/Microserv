package com.travelbox.payment.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private String title;

    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
}
