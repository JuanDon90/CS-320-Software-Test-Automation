package contact;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ContactTest {

    @Test
    void testValidContactCreation() {
        Contact c = new Contact("1234567890", "Juan", "Hernandez", "4045551212", "123 Main St, Atlanta");
        assertEquals("1234567890", c.getContactId());
        assertEquals("Juan", c.getFirstName());
        assertEquals("Hernandez", c.getLastName());
        assertEquals("4045551212", c.getPhone());
        assertEquals("123 Main St, Atlanta", c.getAddress());
    }

    @Test
    void testContactIdNullThrows() {
        assertThrows(IllegalArgumentException.class,
                () -> new Contact(null, "Juan", "Hernandez", "4045551212", "123 Main St"));
    }

    @Test
    void testContactIdTooLongThrows() {
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("12345678901", "Juan", "Hernandez", "4045551212", "123 Main St"));
    }

    @Test
    void testFirstNameNullThrows() {
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("1", null, "Hernandez", "4045551212", "123 Main St"));
    }

    @Test
    void testFirstNameTooLongThrows() {
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("1", "ThisNameTooLong", "Hernandez", "4045551212", "123 Main St"));
    }

    @Test
    void testLastNameNullThrows() {
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("1", "Juan", null, "4045551212", "123 Main St"));
    }

    @Test
    void testLastNameTooLongThrows() {
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("1", "Juan", "LastNameTooLong", "4045551212", "123 Main St"));
    }

    @Test
    void testPhoneNullThrows() {
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("1", "Juan", "Hernandez", null, "123 Main St"));
    }

    @Test
    void testPhoneNotTenDigitsThrows() {
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("1", "Juan", "Hernandez", "12345", "123 Main St"));
    }

    @Test
    void testPhoneHasNonDigitsThrows() {
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("1", "Juan", "Hernandez", "12345abcde", "123 Main St"));
    }

    @Test
    void testAddressNullThrows() {
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("1", "Juan", "Hernandez", "4045551212", null));
    }

    @Test
    void testAddressTooLongThrows() {
        String tooLong = "1234567890123456789012345678901"; // 31 chars
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("1", "Juan", "Hernandez", "4045551212", tooLong));
    }

    @Test
    void testSettersUpdateValidValues() {
        Contact c = new Contact("1", "Juan", "Hernandez", "4045551212", "123 Main St");

        c.setFirstName("J");
        c.setLastName("H");
        c.setPhone("6785559999");
        c.setAddress("456 Peachtree St");

        assertEquals("1", c.getContactId()); // still unchanged
        assertEquals("J", c.getFirstName());
        assertEquals("H", c.getLastName());
        assertEquals("6785559999", c.getPhone());
        assertEquals("456 Peachtree St", c.getAddress());
    }

    @Test
    void testSetterInvalidFirstNameThrows() {
        Contact c = new Contact("1", "Juan", "Hernandez", "4045551212", "123 Main St");
        assertThrows(IllegalArgumentException.class, () -> c.setFirstName(null));
        assertThrows(IllegalArgumentException.class, () -> c.setFirstName("ThisNameTooLong"));
    }

    @Test
    void testSetterInvalidPhoneThrows() {
        Contact c = new Contact("1", "Juan", "Hernandez", "4045551212", "123 Main St");
        assertThrows(IllegalArgumentException.class, () -> c.setPhone("123"));
        assertThrows(IllegalArgumentException.class, () -> c.setPhone("12345abcde"));
    }
}
