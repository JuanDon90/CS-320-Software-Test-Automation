package contact;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ContactService {
    private final Map<String, Contact> contacts = new HashMap<>();

    // Add contact - requires unique contactId
    public void addContact(Contact contact) {
        if (contact == null) {
            throw new IllegalArgumentException("contact cannot be null");
        }
        String id = contact.getContactId();
        if (contacts.containsKey(id)) {
            throw new IllegalArgumentException("contactId already exists: " + id);
        }
        contacts.put(id, contact);
    }

    // Delete contact by ID
    public void deleteContact(String contactId) {
        if (contactId == null) {
            throw new IllegalArgumentException("contactId cannot be null");
        }
        if (!contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("contactId not found: " + contactId);
        }
        contacts.remove(contactId);
    }

    // Update fields by ID (contactId itself is not updatable)
    public void updateFirstName(String contactId, String firstName) {
        getExisting(contactId).setFirstName(firstName);
    }

    public void updateLastName(String contactId, String lastName) {
        getExisting(contactId).setLastName(lastName);
    }

    public void updatePhone(String contactId, String phone) {
        getExisting(contactId).setPhone(phone);
    }

    public void updateAddress(String contactId, String address) {
        getExisting(contactId).setAddress(address);
    }

    // Useful for tests / inspection
    public Contact getContact(String contactId) {
        if (contactId == null) {
            throw new IllegalArgumentException("contactId cannot be null");
        }
        Contact c = contacts.get(contactId);
        if (c == null) {
            throw new IllegalArgumentException("contactId not found: " + contactId);
        }
        return c;
    }

    // Optional: read-only view of all contacts
    public Map<String, Contact> getAllContactsReadOnly() {
        return Collections.unmodifiableMap(contacts);
    }

    private Contact getExisting(String contactId) {
        return getContact(contactId);
    }
}
