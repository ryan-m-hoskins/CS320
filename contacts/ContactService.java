package contacts;

import java.util.Map;
import java.util.NoSuchElementException;
import java.util.HashMap;

public class ContactService {
	private Map<String, Contact> contactList;
	
	// Default Constructor for HashMap
	public ContactService() {
		this.contactList = new HashMap<>();
	}
	// Create a Contact object
	public void createContact(String contactID, String firstName, String lastName, String phone, String address) {
		// Try creating new contact object using passed Contact fields
		try { 
			Contact contact = new Contact(contactID, firstName, lastName, phone, address); 
			addContact(contact);
		}
		// Catch error if unable to create contact, relay error message as needed
		catch (IllegalArgumentException e) {
			System.out.println("Unable to create contact: " + e.getMessage());
		}
	}
	// Method for adding contact
	public void addContact(Contact contact) {
		// If the contact list contains contact ID, throw error stating contact already exists
		if (contactList.containsKey(contact.getContactID())) {
			throw new IllegalArgumentException("Contact already exists. " + contact.getContactID());
		}
		// Put the contact in the hash map 
		contactList.put(contact.getContactID(), contact);
	}
	public Contact getContact(String contactID) {
		return contactList.get(contactID);
	}
	// Method for removing a contact based on Contact ID
	public void removeContact(String contactID) { 
		// IF the contact list does not contain the contact ID, throw error saying as such 
		if (!contactList.containsKey(contactID)) {
			throw new NoSuchElementException("Contact not found");
		}
		// Remove the contact ID
		contactList.remove(contactID);
	}
	// Function for updating Contact using contact ID (key), field, and the new value 
	public void updateContact(String contactID, String field, String newValue) {
		// If the contact list contains the contact ID 
		if (contactList.containsKey(contactID)){
			// Get the contact using the contact ID 
			Contact contact = contactList.get(contactID);
			// Start switch depending on option 
			switch(field) {
				// If first name, call setFirstName and pass new value
				case "firstName":
					contact.setFirstName(newValue);
					break;
				// If last name, call setLastName and pass new value
				case "lastName":
					contact.setLastName(newValue);
					break;
				// If phone, call on setPhone with new value
				case "phone":
					contact.setPhone(newValue);
					break;
				// If address, call setAddress and pass new value
				case "address":
					contact.setAddress(newValue);
					break;
				default: 
					throw new IllegalArgumentException("Unsupported field entered: " + field); 
			}
			// Put the updated contact back into hash map 
			contactList.put(contactID, contact);
		}
		// Otherwise, throw error to inform user contact does not exist. 
		else {
			throw new NoSuchElementException("Contact not found");
		}
	}
}