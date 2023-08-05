/*
The appointment object shall have a required unique appointment ID string that cannot be longer than 10 characters. The appointment ID shall not be null and shall not be updatable.
    The appointment object shall have a required appointment Date field. The appointment Date field cannot be in the past. The appointment Date field shall not be null.
    Note: Use java.util.Date for the appointmentDate field and use before(new Date()) to check if the date is in the past.
    The appointment object shall have a required description String field that cannot be longer than 50 characters. The description field shall not be null.
 */
import org.SNHU.*;
import org.junit.jupiter.api.Test;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class AppointmentTest {
    Appointment appointment = new Appointment();
    @Test
    public void testIDNotNull(){
       assertNotNull(appointment.getId());
    }

    @Test
    public void testDateNotPast(){
        assertThrows(IllegalArgumentException.class, () -> appointment.setDate(new Date(0)));
    }
    @Test
    public void testDateNotNull(){
        assertNotNull(appointment.getDate());
    }
    @Test
    public void descriptionNotNull(){
        assertNotNull(appointment.getDescription());
    }
    @Test
    public void descriptionLengthTooLong(){
        assertThrows(IllegalArgumentException.class, ()
                -> appointment
                .setDescription("012345678901234567890123456789012345678901234567890"));
    }
}
