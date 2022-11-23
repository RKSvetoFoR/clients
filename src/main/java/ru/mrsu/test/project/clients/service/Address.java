package ru.mrsu.test.project.clients.service;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    private int id;           // идентификатор
    private String city;         // город
    private String street;       // улица
    private int house;        // дом
    private int floor;        // этаж
    private int flatNumber;   // квартира


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
