package com.polat.ecommerce.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "PRODUCT")
@Getter
@Setter
public class Product extends BaseModel{

    @Id
    @GeneratedValue(generator = "Product", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "Product", sequenceName = "PRODUCT_ID_SEQ")
    private Long id;

    @Column(name = "NAME", length = 100, nullable = false)
    private String name;

    @Column(name = "PRICE")
    private double price;

    @Column(name = "DESCRIPTION")
    private String description;

    @ManyToOne(cascade = CascadeType.ALL,
               fetch = FetchType.LAZY,
               optional = false )
    private Customer customer;

}
