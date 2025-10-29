package org.example.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private int age;

//    @OneToOne
//    @JoinColumn(name = "id_account")
//    private Account account;

    @Embedded
    private Account account;

    @OneToMany(mappedBy = "user",fetch = FetchType.EAGER)
    private List<Orders> orders;
}
