package org.example.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Embeddable
public class Account {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private long id;

    private String email;
    private String password;

//    @OneToOne(mappedBy = "account")
//    private User user;

    @Override
    public String toString() {
        return "Account{" +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
