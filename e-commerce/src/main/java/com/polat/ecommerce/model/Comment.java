package com.polat.ecommerce.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "COMMENT")
@Getter
@Setter
public class Comment extends BaseModel{

    @Id
    @GeneratedValue(generator = "Comment", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "Comment", sequenceName = "COMMENT_ID_SEQ")
    private Long id;

    @Column(name = "EXPLANATION", length = 500)
    private String explanation;

    @ManyToOne(cascade = CascadeType.ALL,
               fetch = FetchType.LAZY,
               optional = false )
    private Customer customer;

}
