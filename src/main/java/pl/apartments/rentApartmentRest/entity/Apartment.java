package pl.apartments.rentApartmentRest.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.Valid;
import java.time.LocalDate;

@Entity
@Data
public class Apartment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;

    private String content;
    private int apartmentArea;
    private int rooms;
    private Double price;

    private LocalDate created;

    private boolean rented;
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @Valid
    private Address address;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JsonIgnore
    private User ownerUser;
    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private User tenantUser;

}
