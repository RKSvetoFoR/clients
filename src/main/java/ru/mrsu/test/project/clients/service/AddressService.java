package ru.mrsu.test.project.clients.service;

import javax.xml.stream.XMLStreamException;
import java.io.File;
import java.io.FileNotFoundException;

public interface AddressService {
    void getAddresses(File file) throws FileNotFoundException, XMLStreamException;
}
