package addressBook;

import java.util.Objects;

public class Address {
    private String nameStreet;
    private int houseNumber;
    private int apartmentNumber;

    public Address (String nameStreet, int houseNumber, int apartmentNumber) {
        this.nameStreet = nameStreet;
        this.houseNumber = houseNumber;
        this.apartmentNumber = apartmentNumber;
    }

    public String getNameStreet() {
        return nameStreet;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public int getApartmentNumber() {
        return apartmentNumber;
    }

    @Override
    public String toString() {
        return "улица " + nameStreet + " дом " + houseNumber + " квартира " + apartmentNumber + System.lineSeparator();
    }

    @Override
    public boolean equals(Object x) {
        if (this == x) return true;
        if (x == null || getClass() != x.getClass()) return false;
        Address address = (Address) x;
        return nameStreet.equals(address.nameStreet) && houseNumber == address.houseNumber && apartmentNumber == address.apartmentNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameStreet, houseNumber, apartmentNumber);
    }
}
