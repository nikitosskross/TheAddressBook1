package addressBook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AddressBook {
    private HashMap<String, Address> addressBook = new HashMap<String, Address>();

    public void addToBook(String name, Address location) {

        addressBook.put(name, location);
    }

    public void delete(String name) {

        addressBook.remove(name);
    }

    public void changeAddress(String name, Address newAddress) {

        addressBook.replace(name, newAddress);
    }

    public Address personOfBook(String name) {

        return addressBook.get(name);
    }

    public List<String> listPersonByStreet(String street) {

        List<String> person = new ArrayList<>();
        addressBook.forEach((name, address) -> {
            if (address.getNameStreet().equals(street))
                person.add(name);
        });
        return person;
    }

    public List<String> listPersonByHouse(String street, int number) {

        List<String> person = new ArrayList<>();
        addressBook.forEach((name, address) -> {
            if (address.getNameStreet().equals(street) && address.getHouseNumber() == number)
                person.add(name);
        });
        return person;
    }
}
