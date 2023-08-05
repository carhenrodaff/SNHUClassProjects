import org.SNHU.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ContactTest {
    Contact contact;
    @Test
    public void testID(){
        contact = new Contact();
        assertNotNull(contact.contact_ID);
    }
    @Test
    public void testFirstName(){
        contact = new Contact();
        assertNotNull(contact.getFirstName());
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setFirstName("12345678901");
        });
    }
    @Test
    public void testLastName(){
        contact = new Contact();
        assertNotNull(contact.getLastname());
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setLastName("12345678901");
        });
    }
    @Test
    public void testPhone(){
        contact = new Contact();
        assertNotNull(contact.getPhone());
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setPhone("12345678901");
        });
    }
    @Test
    public void testAddress(){
        contact = new Contact();
        assertNotNull(contact.getAddress());
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setAddress("1234567890123456789012345678901");
        });
    }
}