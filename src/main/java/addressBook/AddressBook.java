package addressBook;

import java.util.*;

public class AddressBook {
    private HashMap<String, Address> addressBook = new HashMap<String, Address>();

    public void addToBook(String name, Address location) {
        if (addressBook.containsKey(name))
            throw new IllegalArgumentException("this name is contains in address book");
        if (name.equals("") || name.equals(" "))
            throw new IllegalArgumentException("this name cannot be empty");

        addressBook.put(name, location);
    }

    public void delete(String name) {
        if (!addressBook.containsKey(name))
            throw new IllegalArgumentException("you cannot delete this< because this is empty");

        addressBook.remove(name);
    }

    public void changeAddress(String name, Address newAddress) {
        if (!addressBook.containsKey(name))
            throw new IllegalArgumentException("you cannot change this< because this is empty");

        addressBook.replace(name, newAddress);
    }

    public Address findOfBook(String name) {
        if (!addressBook.containsKey(name))
            throw new IllegalArgumentException("you cannot find this< because this is empty");

        return addressBook.get(name);
    }

    public List<String> listSurnameByStreet(String street) {
        if (street.equals(" ") || street.equals(""))
            throw new IllegalArgumentException("street cannot be empty");

        List<String> person = new ArrayList<>();
        addressBook.forEach((name, address) -> {
            if (address.getNameStreet().equals(street))
                person.add(name);
        });
        return person;
    }

    public List<String> listSurnameByHouse(String street, int number) {
        if (street.equals("") || street.equals(" ") || number < 1)
            throw new IllegalArgumentException("street cannto be empty or incorrect number");

        List<String> person = new ArrayList<>();
        addressBook.forEach((name, address) -> {
            if (address.getNameStreet().equals(street) && address.getHouseNumber() == number)
                person.add(name);
        });
        return person;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        for (Map.Entry<String, Address> x : addressBook.entrySet()) {
            result.append("name: ").append(x.getKey()).append(" - address: ").append(x.getValue());
        }
        return result.toString();
    }
    @Override
    public boolean equals(Object value) {
        if (this == value)
            return true;
        if (value == null || value.getClass() != this.getClass())
            return false;
        AddressBook x = (AddressBook) value;
        return Objects.equals(addressBook, x.addressBook);
    }

    @Override
    public int hashCode() {
        return Objects.hash(addressBook);
    }
}
