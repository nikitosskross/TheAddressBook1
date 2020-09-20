package addressBook;

import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class AddressBookTest {

    private String surname1 = "Potter";
    private String surname2 = "Granger";
    private String surname3 = "Weasley";

    private Address address1 = new Address("Hogwarts Gryffindor", 1, 10);
    private Address address2 = new Address("Hogwarts Hufflepuff", 2, 20);
    private Address address3 = new Address("Hogwarts Slytherin", 4, 40);

    @Test
    void addToBook() {
        AddressBook actualInfo = new AddressBook();
        actualInfo.addToBook(surname1, address1);
        actualInfo.addToBook(surname2, address2);
        AddressBook expectedInfo = new AddressBook();
        expectedInfo.addToBook(surname1, address1);
        expectedInfo.addToBook(surname2, address2);
        assertEquals(expectedInfo, actualInfo);
        AddressBook addressBook = new AddressBook();
        assertEquals(addressBook.findOfBook("name1"), address1);
        System.out.println(actualInfo.toString());
    }

    @Test
    void delete() {
        AddressBook actualInfo = new AddressBook();
        actualInfo.addToBook(surname1, address1);
        actualInfo.addToBook(surname2, address2);
        actualInfo.delete(surname2);
        AddressBook expectedInfo = new AddressBook();
        expectedInfo.addToBook(surname1, address1);
        assertEquals(expectedInfo, actualInfo);
        System.out.println(actualInfo.toString());
    }

    @Test
    void changeAddress() {
        AddressBook actualInfo = new AddressBook();
        actualInfo.addToBook(surname1, address1);
        actualInfo.addToBook(surname2, address2);
        actualInfo.changeAddress(surname1, address3);
        AddressBook expectedInfo = new AddressBook();
        expectedInfo.addToBook(surname1, address3);
        expectedInfo.addToBook(surname2, address2);
        assertEquals(expectedInfo, actualInfo);
        System.out.println(actualInfo.toString());
    }

    @Test
    void findOfBook() {
        AddressBook actualInfo = new AddressBook();
        actualInfo.addToBook(surname1, address1);
        actualInfo.addToBook(surname2, address2);
        AddressBook expectedInfo = new AddressBook();
        expectedInfo.addToBook(surname1, address1);
        expectedInfo.addToBook(surname2, address2);
        assertEquals(address1, actualInfo.findOfBook(surname1));
        System.out.println(actualInfo.findOfBook(surname1).toString());
    }

    @Test
    void listSurnameByStreet() {
        AddressBook actualInfo = new AddressBook();
        actualInfo.addToBook(surname1, address1);
        actualInfo.addToBook(surname2, address1);
        actualInfo.addToBook(surname3, address1);
        HashSet<String> actualSecondNames = new HashSet<>();
        actualSecondNames.add("Potter");
        actualSecondNames.add("Granger");
        actualSecondNames.add("Weasley");
        assertEquals(actualSecondNames, actualInfo.listSurnameByStreet("Hogwarts Gryffindor"));
        System.out.println(actualInfo.listSurnameByStreet("Hogwarts Gryffindor"));
    }

    @Test
    void listSurnameByHouse() {
        AddressBook actualInfo = new AddressBook();
        actualInfo.addToBook(surname1, address1);
        actualInfo.addToBook(surname2, address1);
        actualInfo.addToBook(surname3, address1);
        HashSet<String> actualSecondNames = new HashSet<>();
        actualSecondNames.add("Potter");
        actualSecondNames.add("Granger");
        actualSecondNames.add("Weasley");
        assertEquals(actualSecondNames, actualInfo.listSurnameByHouse("OldStreet", 11));
        System.out.println(actualInfo.listSurnameByStreet("OldStreet"));
    }
}