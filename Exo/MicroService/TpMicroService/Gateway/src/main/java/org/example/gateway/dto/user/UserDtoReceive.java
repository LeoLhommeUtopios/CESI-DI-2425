package org.example.gateway.dto.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDtoReceive {
    private String email;
    private String password;
    private String lastname;
    private String firstname;
}
