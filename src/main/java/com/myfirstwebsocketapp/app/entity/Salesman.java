package com.myfirstwebsocketapp.app.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Entity
@Table
@Getter
@Setter
@EqualsAndHashCode
public class Salesman {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false)
    private Integer numberOfCarsSold;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;
    public enum Role{
        SELLER,
        MANAGER
    }
    @OneToMany(mappedBy = "salesman")
    private List< Orders > sales = new ArrayList<>();

}
