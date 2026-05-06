package org.example.usermicservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.usermicservice.model.enums.Roles;
import org.example.usermicservice.model.enums.Status;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true)
    private String email;
    private String password;
    private String lastname;
    private String firstname;
    private Roles role;
    private Status status;
    private int numberOfTask;

}
