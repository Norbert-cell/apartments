package pl.apartments.rentApartmentRest.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ApartmentDto {

    private long id;
    private String title;
    private String content;
    private int apartmentArea;
    private int rooms;
    private Double price;
    private LocalDate created;
    private boolean rented;

}
