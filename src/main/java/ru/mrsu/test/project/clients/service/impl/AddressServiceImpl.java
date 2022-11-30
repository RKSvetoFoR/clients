package ru.mrsu.test.project.clients.service.impl;

import ru.mrsu.test.project.clients.jpa.AddressRepository;
import ru.mrsu.test.project.clients.service.Address;
import ru.mrsu.test.project.clients.service.AddressService;
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
public class AddressServiceImpl implements AddressService {
    private final AddressRepository addressRepository;
    private final ResourceLoader resourceLoader;
    public AddressServiceImpl(AddressRepository addressRepository, ResourceLoader resourceLoader) {
        this.addressRepository = addressRepository;
        this.resourceLoader = resourceLoader;
    }
    @Override
    public List<Address> getAddresses() {
        XMLInputFactory factory = XMLInputFactory.newInstance();
        XMLStreamReader parser = null;

        try {
            Resource resource = resourceLoader.getResource("classpath:address.xml");
            InputStream inputStream = resource.getInputStream();
            parser = factory.createXMLStreamReader(inputStream);
        } catch (FileNotFoundException e) {
            System.out.println("Check file path");
        } catch (XMLStreamException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        ArrayList<Address> addressList = new ArrayList();

        try {
            while (true) {
                assert parser != null;
                if (!parser.hasNext()) break;
                int event = parser.next();
                if (event == XMLStreamConstants.START_ELEMENT) {
                    if (parser.getLocalName().equals("address")) {
                        Address address = new Address();
                        int id = Integer.parseInt(parser.getAttributeValue(0));
                        String city = parser.getAttributeValue(1);
                        String street = parser.getAttributeValue(2);
                        int house = Integer.parseInt(parser.getAttributeValue(3));
                        int floor = Integer.parseInt(parser.getAttributeValue(4));
                        int flatNumber = Integer.parseInt(parser.getAttributeValue(5));
                        address.setId(id);
                        address.setCity(city);
                        address.setStreet(street);
                        address.setHouse(house);
                        address.setFloor(floor);
                        address.setFlatNumber(flatNumber);
                        addressList.add(address);
                    }
                }
            }
        } catch (XMLStreamException e) {
            System.out.println(e.getMessage());
        }
        return addressList;
    }

}
