package ru.mrsu.test.project.clients.service.impl;

<<<<<<< HEAD
import ru.mrsu.test.project.clients.service.Address;
import ru.mrsu.test.project.clients.service.AddressService;
import ru.mrsu.test.project.clients.service.ClientService;

=======
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import ru.mrsu.test.project.clients.service.Address;
import ru.mrsu.test.project.clients.service.AddressService;
import org.springframework.stereotype.Service;
>>>>>>> 0d65978 (Initial commit)
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
<<<<<<< HEAD
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
=======
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
@Service
public class AddressServiceImpl implements AddressService {
    private final ResourceLoader resourceLoader;
    public AddressServiceImpl(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }
    @Override
    public List<Address> getAddresses() {
>>>>>>> 0d65978 (Initial commit)
        XMLInputFactory factory = XMLInputFactory.newInstance();
        XMLStreamReader parser = null;

        try {
<<<<<<< HEAD
            parser = factory.createXMLStreamReader(new FileInputStream(file));
=======
            Resource resource = resourceLoader.getResource("resources/client.xml");
            InputStream inputStream = resource.getInputStream();
            parser = factory.createXMLStreamReader(inputStream);
>>>>>>> 0d65978 (Initial commit)
        } catch (FileNotFoundException e) {
            System.out.println("Check file path");
        } catch (XMLStreamException e) {
            System.out.println(e.getMessage());
<<<<<<< HEAD
        }
        ArrayList<Address> addressList = new ArrayList<Address>();
=======
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        ArrayList<Address> addressList = new ArrayList();
>>>>>>> 0d65978 (Initial commit)

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
<<<<<<< HEAD
        return null;
=======
        return addressList;
>>>>>>> 0d65978 (Initial commit)
    }

}
