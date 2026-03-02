package contact;

import java.util.Objects;

public class Contact {
    private final String contactId;     // NOT updatable
    private String firstName;
    private String lastName;
    private String phone;
    private String address;

    public Contact(String contactId, String firstName, String lastName, String phone, String address) {
        validateContactId(contactId);
        validateFirstName(firstName);
        validateLastName(lastName);
        validatePhone(phone);
        validateAddress(address);

        this.contactId = contactId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
    }

    // Getters
    public String getContactId() {
        return contactId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    // Setters (contactId has NO setter)
    public void setFirstName(String firstName) {
        validateFirstName(firstName);
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        validateLastName(lastName);
        this.lastName = lastName;
    }

    public void setPhone(String phone) {
        validatePhone(phone);
        this.phone = phone;
    }

    public void setAddress(String address) {
        validateAddress(address);
        this.address = address;
    }

    // Validation helpers
    private static void validateContactId(String contactId) {
        if (contactId == null) {
            throw new IllegalArgumentException("contactId cannot be null");
        }
        if (contactId.length() > 10) {
            throw new IllegalArgumentException("contactId cannot be longer than 10 characters");
        }
    }

    private static void validateFirstName(String firstName) {
        if (firstName == null) {
            throw new IllegalArgumentException("firstName cannot be null");
        }
        if (firstName.length() > 10) {
            throw new IllegalArgumentException("firstName cannot be longer than 10 characters");
        }
    }

    private static void validateLastName(String lastName) {
        if (lastName == null) {
            throw new IllegalArgumentException("lastName cannot be null");
        }
        if (lastName.length() > 10) {
            throw new IllegalArgumentException("lastName cannot be longer than 10 characters");
        }
    }

    private static void validatePhone(String phone) {
        if (phone == null) {
            throw new IllegalArgumentException("phone cannot be null");
        }
        if (phone.length() != 10) {
            throw new IllegalArgumentException("phone must be exactly 10 digits");
        }
        for (int i = 0; i < phone.length(); i++) {
            if (!Character.isDigit(phone.charAt(i))) {
                throw new IllegalArgumentException("phone must contain digits only");
            }
        }
    }

    private static void validateAddress(String address) {
        if (address == null) {
            throw new IllegalArgumentException("address cannot be null");
        }
        if (address.length() > 30) {
            throw new IllegalArgumentException("address cannot be longer than 30 characters");
        }
    }

    // Optional: helpful for debugging/printing
    @Override
    public String toString() {
        return "Contact{" +
                "contactId='" + contactId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
