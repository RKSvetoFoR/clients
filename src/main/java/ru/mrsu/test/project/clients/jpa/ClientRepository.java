package ru.mrsu.test.project.clients.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mrsu.test.project.clients.service.Client;
import ru.mrsu.test.project.clients.service.impl.ClientServiceImpl;

public interface ClientRepository extends JpaRepository<Client, Integer> { }
