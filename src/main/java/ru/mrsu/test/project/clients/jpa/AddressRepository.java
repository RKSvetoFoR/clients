package ru.mrsu.test.project.clients.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mrsu.test.project.clients.service.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> { }
