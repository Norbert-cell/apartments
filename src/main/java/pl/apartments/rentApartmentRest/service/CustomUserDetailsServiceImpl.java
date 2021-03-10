package pl.apartments.rentApartmentRest.service;

import javassist.NotFoundException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.apartments.rentApartmentRest.entity.User;
import pl.apartments.rentApartmentRest.repository.UserRepository;

@Service
@Transactional
public class CustomUserDetailsServiceImpl implements CustomUserDetailsService {

    private final UserRepository userRepository;

    public CustomUserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = null;
        try {
            user = userRepository.findByUsername(email).orElseThrow(()->new NotFoundException("Nie znaleziono"));
        } catch (NotFoundException e) {
            e.printStackTrace();
        }
        return user ;
    }
}
