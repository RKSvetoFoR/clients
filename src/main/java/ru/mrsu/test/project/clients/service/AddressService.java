package ru.mrsu.test.project.clients.service;

<<<<<<< HEAD
import javax.xml.stream.XMLStreamException;
import java.io.File;
import java.io.FileNotFoundException;

public interface AddressService {
    void getAddresses(File file) throws FileNotFoundException, XMLStreamException;
=======
import java.util.List;

public interface AddressService {

    List<Address> getAddresses();

>>>>>>> 0d65978 (Initial commit)
}
