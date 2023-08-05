/**
 * 
 */
package org.SNHU;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author Carlos Affonso
 *
 *  The contact object shall have a required unique contact ID string that cannot be longer than 10 characters. The contact ID shall not be null and shall not be updatable.
 *  The contact object shall have a required firstName String field that cannot be longer than 10 characters. The firstName field shall not be null.
 *  The contact object shall have a required lastName String field that cannot be longer than 10 characters. The lastName field shall not be null.
 *  The contact object shall have a required phone String field that must be exactly 10 digits. The phone field shall not be null.
 *  The contact object shall have a required address field that must be no longer than 30 characters. The address field shall not be null.

 */
public class Contact {

	public final String contact_ID = createID();

	private static AtomicLong counter;
	private String firstName = "noname";
	private String lastName = "noname";
	private String phone = "0000000000";
	private String address = "noaddress";

	private String createID() {
		counter = new AtomicLong();
		String ID = counter.toString();
		counter.incrementAndGet();
		if (counter.intValue() > 999999999) {
			throw new IllegalArgumentException("Too many IDs");
		}
		return ID;
	}

	public void setFirstName(String firstName) {
		if (firstName.length() > 10) {
			throw new IllegalArgumentException("First name too long");
		}
		this.firstName = firstName;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		if (lastName.length() > 10) {
			throw new IllegalArgumentException("Last name too long");
		}
		this.lastName = lastName;
	}
	public String getLastname() {
		return lastName;
	}
	public void setPhone(String phone){
		if (phone.length() != 10) {
			throw new IllegalArgumentException("Phone number must be 10 digits");
		}
		this.phone = phone;
	}
	public String getPhone(){
		return phone;
	}
	public void setAddress(String address){
		if (address.length() > 30) {
			throw new IllegalArgumentException("Address too long");
		}
		this.address = address;
	}
	public String getAddress(){
		return address;
	}
}
