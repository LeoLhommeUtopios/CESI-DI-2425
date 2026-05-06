package org.example.usermicservice.dto;

import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDtoReceive {
    private String email;
    @Min(8)
    private String password;
    private String lastname;
    private String firstname;
}
