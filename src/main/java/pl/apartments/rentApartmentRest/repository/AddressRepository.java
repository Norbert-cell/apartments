package pl.apartments.rentApartmentRest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.apartments.rentApartmentRest.entity.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
}
