package com.polat.ecommerce.model;

import com.polat.ecommerce.enums.EnumCustomerType;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "CUSTOMER")
@Getter
@Setter
public class Customer extends BaseModel{

    @Id
    @GeneratedValue(generator = "Customer", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "Customer", sequenceName = "CUSTOMER_ID_SEQ")
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME", length = 100, nullable = false)
    private String name;

    @Column(name = "SURNAME", length = 100, nullable = false)
    private String surname;

    @NotBlank
    @Column(name = "USERNAME", length = 50, nullable = false, unique = true)
    private String username;

    @NotNull
    @Column(name = "PASSWORD", length = 400, nullable = false)
    private String password;

    @Email
    @Column(name = "EMAIL", length = 50, unique = true)
    private String email;

    @Column(name = "PHONE", length = 50, unique = true)
    private String phone;

    @Column(name = "TYPE", length = 30)
    @Enumerated(EnumType.STRING)
    private EnumCustomerType type;

    @OneToMany(fetch = FetchType.LAZY,
               cascade = CascadeType.ALL,
               mappedBy = "customer",
               targetEntity = Comment.class)
    private List<Comment> comment = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            mappedBy = "customer",
            targetEntity = Product.class
    )
    private List<Product> products = new ArrayList<>();

}
