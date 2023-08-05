import org.SNHU.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ContactServiceTest {
    ContactService contact = new ContactService();
    @Test
    public void testAddContact(){
        contact = new ContactService();
        Contact contact1 = new Contact();
        contact1.setFirstName("C");
        contact1.setLastName("A");
        contact1.setPhone("1234567890");
        contact1.setAddress("123 Main St");
        contact.addContact(contact1);
        assertEquals(ContactService.Contacts.get(contact1.contact_ID), contact1);
    }
    @Test
    public void testDeleteContact(){
        contact = new ContactService();
        Contact contact1 = new Contact();
        contact1.setFirstName("C");
        contact1.setLastName("A");
        contact1.setPhone("1234567890");
        contact1.setAddress("123 Main St");
        contact.addContact( contact1);
        contact.deleteContact(contact1.contact_ID);
        assertNull(ContactService.Contacts.get(contact1.contact_ID));
    }
    @Test
    public void testUpdateContact(){
        contact = new ContactService();
        Contact contact1 = new Contact();
        contact1.setFirstName("C");
        contact1.setLastName("A");
        contact1.setPhone("1234567890");
        contact1.setAddress("123 Main St");
        contact.addContact( contact1);
        contact.updateContact(1, contact1.contact_ID, "Carlos");
        assertEquals(ContactService.Contacts.get(contact1.contact_ID).getFirstName(), "Carlos");
        contact.updateContact(2, contact1.contact_ID, "Affonso");
        assertEquals(ContactService.Contacts.get(contact1.contact_ID).getLastName(), "Affonso");
        contact.updateContact(3, contact1.contact_ID, "1234567890");
        assertEquals(ContactService.Contacts.get(contact1.contact_ID).getPhone(), "1234567890");
        contact.updateContact(4, contact1.contact_ID, "123 Main St");
        assertEquals(ContactService.Contacts.get(contact1.contact_ID).getAddress(), "123 Main St");
    }
}