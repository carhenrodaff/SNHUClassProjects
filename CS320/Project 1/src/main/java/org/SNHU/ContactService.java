package org.SNHU;

import org.mockito.*;
import java.util.HashMap;
/*
 * @author Carlos Affonso
 * Reqs:
 * 		
    The contact service shall be able to add contacts with a unique ID.
    The contact service shall be able to delete contacts per contact ID.
    The contact service shall be able to update contact fields per contact ID. The following fields are updatable:
        firstName
        lastName
        Number
        Address

 */
public class ContactService{

	@Mock
	public static HashMap<String, org.SNHU.Contact> Contacts = new HashMap<String, Contact>();

	public void addContact(org.SNHU.Contact newContact){
		Contacts.put(newContact.contact_ID, newContact);
		}
	public void deleteContact(String ID){
		if(Contacts.containsKey(ID)){
			Contacts.remove(ID);
		}
		else{
			throw new IllegalArgumentException("Invalid ID");
		}
	}
	public void updateContact(int choice,String userID, String information){
		switch(choice){
			case 1:
				//update first name and is less than 10 characters
				if(information.length() < 10){
					Contacts.get(userID).setFirstName(information);
				}
			case 2:
				//update last name
				if(information.length() < 10) {
					Contacts.get(userID).setLastName(information);
				}
				break;
			case 3:
				//update phone
				if(information.length() < 10) {
					Contacts.get(userID).setPhone(information);
				}
				break;
			case 4:
				//update address
				if(information.length() < 30) {
					Contacts.get(userID).setAddress(information);
				}
				break;
			default:
				//error
				throw new IllegalArgumentException("Invalid choice");
		}
	}

}
