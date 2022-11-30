package ru.mrsu.test.project.clients.controller;

import org.springframework.web.bind.annotation.PostMapping;
import ru.mrsu.test.project.clients.service.Address;
import ru.mrsu.test.project.clients.service.AddressService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RestController
public class AddressController {
    private final AddressService addressService;

    public AddressController(AddressService addressService){
        this.addressService = addressService;
    }

    @GetMapping("internal/addresses")
    public List<Address> getAddress() {
        return addressService.getAddresses();
    }

    @PostMapping("internal/addresses")
    public List<Address> setAddress() {
        return addressService.setAddresses();
    }
}

