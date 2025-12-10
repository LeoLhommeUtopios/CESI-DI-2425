package org.example.demosecurity;

import org.example.demosecurity.entity.User;
import org.example.demosecurity.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class DemoSecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoSecurityApplication.class, args);
    }

//        @Bean
//        CommandLineRunner initDatabase(UserRepository userRepository,
//                                       PasswordEncoder passwordEncoder) {
//            return args -> {
//                // Initialisation des utilisateurs
//                User user = new User("user", passwordEncoder.encode("user123"), "ROLE_USER");
//                User admin = new User("admin", passwordEncoder.encode("admin123"), "ROLE_ADMIN");
//                userRepository.save(user);
//                userRepository.save(admin);
//            };
//        }

}
