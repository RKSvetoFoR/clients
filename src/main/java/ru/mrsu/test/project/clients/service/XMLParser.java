package ru.mrsu.test.project.clients.service;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class XMLParser implements ClientService {

    @Override
    public void parseAddress(File file) {
       readAddress(file);
    }
    @Override
    public void parseClient(File file) {
        readClient(file);
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

    private List<Client> readClient(File file) {
        XMLInputFactory factory = XMLInputFactory.newInstance();
        XMLStreamReader parser = null;

        try {
            parser = factory.createXMLStreamReader(new FileInputStream(file));
        } catch (FileNotFoundException e) {
            System.out.println("Check file path");
        } catch (XMLStreamException e) {
            System.out.println(e.getMessage());
        }
        ArrayList<Client> clientList = new ArrayList<Client>();

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
        return null;
    }


}
