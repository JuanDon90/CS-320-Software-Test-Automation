package contact;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ContactServiceTest {

    @Test
    void testAddContactSuccess() {
        ContactService service = new ContactService();
        Contact c = new Contact("1", "Juan", "Hernandez", "4045551212", "123 Main St");

        service.addContact(c);
        Contact stored = service.getContact("1");

        assertEquals("Juan", stored.getFirstName());
        assertEquals("Hernandez", stored.getLastName());
    }

    @Test
    void testAddDuplicateIdThrows() {
        ContactService service = new ContactService();
        service.addContact(new Contact("1", "Juan", "Hernandez", "4045551212", "123 Main St"));

        assertThrows(IllegalArgumentException.class, () ->
                service.addContact(new Contact("1", "A", "B", "6785559999", "456 Another St")));
    }

    @Test
    void testDeleteContactSuccess() {
        ContactService service = new ContactService();
        service.addContact(new Contact("1", "Juan", "Hernandez", "4045551212", "123 Main St"));

        service.deleteContact("1");

        assertThrows(IllegalArgumentException.class, () -> service.getContact("1"));
    }

    @Test
    void testDeleteNonexistentThrows() {
        ContactService service = new ContactService();
        assertThrows(IllegalArgumentException.class, () -> service.deleteContact("999"));
    }

    @Test
    void testUpdateFirstNameSuccess() {
        ContactService service = new ContactService();
        service.addContact(new Contact("1", "Juan", "Hernandez", "4045551212", "123 Main St"));

        service.updateFirstName("1", "J");

        assertEquals("J", service.getContact("1").getFirstName());
    }

    @Test
    void testUpdateLastNameSuccess() {
        ContactService service = new ContactService();
        service.addContact(new Contact("1", "Juan", "Hernandez", "4045551212", "123 Main St"));

        service.updateLastName("1", "H");

        assertEquals("H", service.getContact("1").getLastName());
    }

    @Test
    void testUpdatePhoneSuccess() {
        ContactService service = new ContactService();
        service.addContact(new Contact("1", "Juan", "Hernandez", "4045551212", "123 Main St"));

        service.updatePhone("1", "6785559999");

        assertEquals("6785559999", service.getContact("1").getPhone());
    }

    @Test
    void testUpdateAddressSuccess() {
        ContactService service = new ContactService();
        service.addContact(new Contact("1", "Juan", "Hernandez", "4045551212", "123 Main St"));

        service.updateAddress("1", "456 Peachtree St");

        assertEquals("456 Peachtree St", service.getContact("1").getAddress());
    }

    @Test
    void testUpdateNonexistentIdThrows() {
        ContactService service = new ContactService();
        assertThrows(IllegalArgumentException.class, () -> service.updatePhone("999", "4045551212"));
    }

    @Test
    void testUpdateInvalidValueThrows() {
        ContactService service = new ContactService();
        service.addContact(new Contact("1", "Juan", "Hernandez", "4045551212", "123 Main St"));

        // invalid phone
        assertThrows(IllegalArgumentException.class, () -> service.updatePhone("1", "123"));
        // invalid first name
        assertThrows(IllegalArgumentException.class, () -> service.updateFirstName("1", "ThisNameTooLong"));
    }
}
