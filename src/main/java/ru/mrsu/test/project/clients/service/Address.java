package ru.mrsu.test.project.clients.service;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    @Id
    @Column(name = "address_id")
    private int id;
    @Column(name = "address_city")
    private String city;
    @Column(name = "addresss_street")
    private String street;
    @Column(name = "address_house")
    private int house;
    @Column(name = "address_floor")
    private int floor;
    @Column(name = "flat_number")
    private int flatNumber;


    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", house=" + house +
                ", floor=" + floor +
                ", flatNumber=" + flatNumber +
                '}';
    }
}
