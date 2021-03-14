package pl.apartments.rentApartmentRest.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;

@Entity
@Data
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.PROTECTED)
    private long id;
    private String street;
    private String streetNumber;
    @Pattern(regexp = "^[0-9]{2}-[0-9]{3}$")
    private String postCode;
    private String city;
}
