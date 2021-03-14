package pl.apartments.rentApartmentRest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.apartments.rentApartmentRest.entity.Apartment;

import java.util.List;

@Repository
public interface ApartmentRepository extends JpaRepository<Apartment,Long> {

    List<Apartment> findApartmentsByRentedIsFalse();
}
