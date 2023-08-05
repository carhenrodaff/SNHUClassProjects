package org.SNHU;
import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;

/*
Name: Carlos Affonso
Date: 07/27/2023
 */
/*
Appointment Class Requirements

    The appointment object shall have a required unique appointment ID string that cannot be longer than 10 characters. The appointment ID shall not be null and shall not be updatable.
    The appointment object shall have a required appointment Date field. The appointment Date field cannot be in the past. The appointment Date field shall not be null.
    Note: Use java.util.Date for the appointmentDate field and use before(new Date()) to check if the date is in the past.
    The appointment object shall have a required description String field that cannot be longer than 50 characters. The description field shall not be null.

 */
public class Appointment {
    static AtomicLong uniqueID = new AtomicLong();
    private final String id = createId();
    private Date appointmentDate;
    private String description = "nodesc";

    public Appointment(){
        String id = "";
        appointmentDate = new Date();
        String description = "nodesc";
    }
    public void setDate(Date date){
        if(date == null || date.before(appointmentDate)){
            throw new IllegalArgumentException("Date in the past.");
        }
        this.appointmentDate = date;
    }
    public Date getDate(){return appointmentDate;}
    public void setDescription(String description){
        if(description == null || description.length() > 50){
            throw new IllegalArgumentException("Description is too long");
        }
    }
    public String getDescription(){return description;}
    public String createId(){
        String id = uniqueID.toString();
        uniqueID.incrementAndGet();
        if(uniqueID.intValue() > 999999999){
            throw new IllegalArgumentException("Too many IDs");
        }
        return id;
    }
    public String getId(){
        return id;
    }
}