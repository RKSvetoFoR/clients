package ru.mrsu.test.project.clients.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import ru.mrsu.test.project.clients.jpa.ClientRepository;
import ru.mrsu.test.project.clients.service.Client;
import ru.mrsu.test.project.clients.service.ClientService;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    private final ClientRepository clientRepository;
    private final ResourceLoader resourceLoader;
    public ClientServiceImpl(ClientRepository clientRepository, ResourceLoader resourceLoader) {
        this.clientRepository = clientRepository;
        this.resourceLoader = resourceLoader;
    }
    @Override
    public List<Client> getClients() {
        XMLInputFactory factory = XMLInputFactory.newInstance();
        XMLStreamReader parser = null;

        try {
            Resource resource = resourceLoader.getResource("classpath:client.xml");
            InputStream inputStream = resource.getInputStream();
            parser = factory.createXMLStreamReader(inputStream);
        } catch (FileNotFoundException e) {
            System.out.println("Check file path");
        } catch (XMLStreamException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        ArrayList<Client> clientList = new ArrayList();

        try {
            while (true) {
                assert parser != null;
                if (!parser.hasNext()) break;
                int event = parser.next();
                if (event == XMLStreamConstants.START_ELEMENT) {
                    if (parser.getLocalName().equals("client")) {
                        Client client = new Client();
                        int id = Integer.parseInt(parser.getAttributeValue(0));
                        String name = parser.getAttributeValue(1);
                        String personnelNumber = parser.getAttributeValue(2);
                        int addressId = Integer.parseInt(parser.getAttributeValue(3));
                        client.setId(id);
                        client.setName(name);
                        client.setPersonnelNumber(personnelNumber);
                        client.setAddressId(addressId);
                        clientList.add(client);
                    }
                }
            }
        } catch (XMLStreamException e) {
            System.out.println(e.getMessage());
        }
        return clientList;
    }
    public List<Client> setClients(){
        return clientRepository.saveAll(getClients());
    }

}
