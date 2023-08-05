package org.SNHU;
import org.mockito.Mock;

import java.util.HashMap;

/*
Appointment Service Requirements

    The appointment service shall be able to add appointments with a unique appointment ID.
    The appointment service shall be able to delete appointments per appointment ID.

 */
public class AppointmentService {
    @Mock
    public static HashMap<String, Appointment>Appointments = new HashMap<>();
    public static void addAppointment(Appointment Appointment){
        Appointments.put(Appointment.getId(), Appointment);
    }
    public static void deleteAppointment(String id){
        if(Appointments.containsKey(id)){
            Appointments.remove(id);
        }
        else{
            throw new IllegalArgumentException("No Appointment with specified ID");
        }
    }
}
