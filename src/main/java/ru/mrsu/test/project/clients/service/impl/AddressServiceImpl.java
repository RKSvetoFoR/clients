package ru.mrsu.test.project.clients.service.impl;

import ru.mrsu.test.project.clients.service.Address;
import ru.mrsu.test.project.clients.service.AddressService;
import ru.mrsu.test.project.clients.service.ClientService;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class AddressServiceImpl implements AddressService {
    @Override
    public void getAdresses(File file) {
        readAddress(file);
    }


    private List<Address> readAddress(File file) {
        XMLInputFactory factory = XMLInputFactory.newInstance();
        XMLStreamReader parser = null;

        try {
            parser = factory.createXMLStreamReader(new FileInputStream(file));
        } catch (FileNotFoundException e) {
            System.out.println("Check file path");
        } catch (XMLStreamException e) {
            System.out.println(e.getMessage());
        }
        ArrayList<Address> addressList = new ArrayList<Address>();

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
        return null;
    }

}
