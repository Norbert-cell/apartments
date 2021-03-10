package pl.apartments.rentApartmentRest.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.apartments.rentApartmentRest.entity.User;
import pl.apartments.rentApartmentRest.repository.UserRepository;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    public boolean isExistEmail(String email) {
        Optional<User> byUserName = userRepository.findByUsername(email);
        return byUserName.isPresent();
    }

    public void save(User user) {
        user.setCreated(LocalDate.now());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

}
