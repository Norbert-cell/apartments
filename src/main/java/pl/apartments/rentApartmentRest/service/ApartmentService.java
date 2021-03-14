package pl.apartments.rentApartmentRest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.apartments.rentApartmentRest.entity.Apartment;
import pl.apartments.rentApartmentRest.entity.User;
import pl.apartments.rentApartmentRest.repository.ApartmentRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ApartmentService {

    private final ApartmentRepository apartmentRepository;
    private final UserService userService;

    @Autowired
    public ApartmentService(ApartmentRepository apartmentRepository, UserService userService) {
        this.apartmentRepository = apartmentRepository;
        this.userService = userService;
    }

    public List<Apartment> getAllApartmentsWhereRentedIsFalse(){
        return apartmentRepository.findApartmentsByRentedIsFalse();
    }

    public Apartment saveApartment(Apartment apartment, String name) {
        Optional<User> optionalUser = userService.findByUsername(name);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            apartment.setOwnerUser(user);
            apartment.setCreated(LocalDate.now());
            apartment.setRented(false);
            apartmentRepository.save(apartment);
            return apartment;
        }
        return new Apartment();
    }
}
