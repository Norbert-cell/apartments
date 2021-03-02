package pl.apartments.rentApartmentRest.service;

import org.springframework.stereotype.Service;
import pl.apartments.rentApartmentRest.entity.User;
import pl.apartments.rentApartmentRest.repository.UserRepository;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public boolean isExistEmail(String email) {
        Optional<User> byUserName = userRepository.findByUsername(email);
        return byUserName.isPresent();
    }
}
