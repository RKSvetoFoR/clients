package ru.mrsu.test.project.clients.service;

import javax.xml.stream.XMLStreamException;
import java.io.File;
import java.io.FileNotFoundException;

public interface ClientService {
    void getClients(File file) throws FileNotFoundException, XMLStreamException;
}
