import org.SNHU.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/*
Appointment Service Requirements

        The appointment service shall be able to add appointments with a unique appointment ID.
        The appointment service shall be able to delete appointments per appointment ID.

        */
public class AppointmentServiceTest {
    @Test
    public void testAddAppointment(){
        Appointment appointment = new Appointment();
        AppointmentService.addAppointment(appointment);
        assertTrue(AppointmentService.Appointments.containsKey(appointment.getId()));
    }
    @Test
    public void testDeleteAppointment(){
        Appointment appointment = new Appointment();
        AppointmentService.addAppointment(appointment);
        AppointmentService.deleteAppointment(appointment.getId());
        assertFalse(AppointmentService.Appointments.containsKey(appointment.getId()));
    }

}
