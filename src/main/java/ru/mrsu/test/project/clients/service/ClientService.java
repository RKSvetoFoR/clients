package ru.mrsu.test.project.clients.service;

<<<<<<< HEAD
import javax.xml.stream.XMLStreamException;
import java.io.File;
import java.io.FileNotFoundException;

public interface ClientService {
    void getClients(File file) throws FileNotFoundException, XMLStreamException;
=======
import java.util.List;

public interface ClientService {

    List<Client> getClients();
>>>>>>> 0d65978 (Initial commit)
}
