package contacts;

import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ContactServiceTest {	
	
	private ContactService service;
	
	@BeforeEach
	public void setUp() {
		service = new ContactService();
	}
	// Testing to add a single contact
	@Test
	void testAddSingleContact() {
		// Declare variables for Contact
		String validContactID = "0987654321";
		String validFirstName = "James";
		String validLastName = "Holden";
		String validPhone = "1234567890";
		String validAddress = "123 Roci Dr";
		Contact contact = new Contact(validContactID, validFirstName, validLastName, validPhone, validAddress);
		// Attempt to add contact
		service.addContact(contact);
		// Retrieve contact 
		Contact retrievedContact = service.getContact(validContactID);
		
		assertNotNull(retrievedContact, "Contact Successfully Added");
	}
	// Testing adding multiple contacts
	@Test
	void testAddMultipleContacts() {
		String validContactID = "0987654321";
		String validFirstName = "James";
		String validLastName = "Holden";
		String validPhone = "1234567890";
		String validAddress = "123 Roci Dr";
		Contact contact1 = new Contact(validContactID, validFirstName, validLastName, validPhone, validAddress);
		service.addContact(contact1);
		
		Contact contact2 = new Contact("02", "Amos", "Burton", "0987654321", "321 Roci Ave");
		service.addContact(contact2);
		
		assertNotNull(contact1, "Contact Sucessfully Added"); 
		assertNotNull(contact2, "Contact Successfully Added");
		assertEquals(contact1, service.getContact("0987654321"));
		assertEquals(contact2, service.getContact("02"));
	}
	// Testing adding a duplicate contact ID 
	@Test
	void testAddDuplicateContact() {
		String validContactID = "0987654321";
		String validFirstName = "James";
		String validLastName = "Holden";
		String validPhone = "1234567890";
		String validAddress = "123 Roci Dr";
		Contact contact1 = new Contact(validContactID, validFirstName, validLastName, validPhone, validAddress);
		service.addContact(contact1);
		
		Contact contact2 = new Contact("01", "Amos", "Burton", "0987654321", "321 Roci Ave");
		service.addContact(contact2);
				
		assertThrows(IllegalArgumentException.class, () ->  service.addContact(contact2));
	}
	
	// Testing adding and retrieving a contact
	@Test
	void testAddAndRetrieveContact() {
		String validContactID = "0987654321";
		String validFirstName = "James";
		String validLastName = "Holden";
		String validPhone = "1234567890";
		String validAddress = "123 Roci Dr";
		Contact contact1 = new Contact(validContactID, validFirstName, validLastName, validPhone, validAddress);
		service.addContact(contact1);
		
		assertEquals(contact1, service.getContact("0987654321"));
	}
	// Testing to create a single contact
	@Test
	void testCreateSingleContact() {
		service.createContact("01", "Amos", "Burton", "0987654321", "321 Roci Ave");
		Contact contact = service.getContact("01");
		assertNotNull(contact, "Contact Successfully Created");
	}
	// Testing to create a contact with null contact ID 
	@Test
	void testCreateContactNull() {
		service.createContact(null, "Amos", "Burton", "0987654321", "321 Roci Ave"); // Contact ID is null
		assertNull(service.getContact(null));
	}
	// Test to update first name
	@Test
	void testUpdateContactFirstName() {
		service.createContact("01", "Amos", "Burton", "0987654321", "321 Roci Ave");
		service.updateContact("01", "firstName", "Sam");
		assertEquals("Sam", service.getContact("01").getFirstName());
	}
	// Test to update to invalid first name
	@Test
	void testUpdateContactFirstNameInvalid() {
		service.createContact("01", "Amos", "Burton", "0987654321", "321 Roci Ave");
		// Throw error when attempting to update first name to one that is too long
		assertThrows(IllegalArgumentException.class,() -> service.updateContact("01", "firstName", "JamesHoldenn"));
	}
	// Test to update last name
	@Test
	void testUpdateContactLastName() {
		service.createContact("01", "Amos", "Burton", "0987654321", "321 Roci Ave");
		service.updateContact("01", "lastName", "Draper");
		assertEquals("Draper", service.getContact("01").getLastName());
	}
	// Test to update to invalid last name
	@Test
	void testUpdateContactLastNameInvalid() {
		service.createContact("01", "Amos", "Burton", "0987654321", "321 Roci Ave");
		// Throw error when attempting to updated phone number with invalid character
		assertThrows(IllegalArgumentException.class,() -> service.updateContact("01", "lastName", "HoldenJamess"));
	}
	// Test to update valid phone
	@Test
	void testUpdateContactPhone() {
		service.createContact("01", "Amos", "Burton", "0987654321", "321 Roci Ave");
		service.updateContact("01", "phone", "1234567890");
		assertEquals("1234567890", service.getContact("01").getPhone());
	}
	// Test to update invalid phone
	@Test
	void testUpdateContactPhoneInvalid() {
		service.createContact("01", "Amos", "Burton", "0987654321", "321 Roci Ave");
		// Throw error when attempting to updated phone number with invalid character
		assertThrows(IllegalArgumentException.class,() -> service.updateContact("01", "phone", "12345s7890"));
	}
	// Test to update to invalid phone length 
	@Test
	void testUpdateContactPhoneInvalidLength() {
		service.createContact("01", "Amos", "Burton", "0987654321", "321 Roci Ave");
		// Throw error when attempting to updated phone number with 9 digits
		assertThrows(IllegalArgumentException.class,() -> service.updateContact("01", "phone", "123456789"));
	}
	// Test to update to address
	@Test
	void testUpdateContactAddress() {
		// Create Contact
		service.createContact("01", "Amos", "Burton", "0987654321", "321 Roci Ave");
		// Update address
		service.updateContact("01", "address", "456 Belter Way");
		// Ensure updated address is what it should be
		assertEquals("456 Belter Way", service.getContact("01").getAddress());
	}
	// Test to update to invalid address
	@Test
	void testUpdateContactAddressInvalid() {
		service.createContact("01", "Amos", "Burton", "0987654321", "321 Roci Ave");
		assertThrows(IllegalArgumentException.class,() -> service.updateContact("01", "address", "1234567890 Belter Way, Not Mars or Earth or Anywhere Else"));
	}
	// Testing to remove contact
	@Test
	void testRemoveContact() { 
		service.createContact("01", "Amos", "Burton", "0987654321", "321 Roci Ave");
		// Try to remove contact with contact ID
		try { 
			service.removeContact("01");
		}
		// Catch error if unable to 
		catch (NoSuchElementException e) {
			fail("Error: " + e.getMessage());
		}
		// Checking to ensure contact has been removed
		Contact removedContact = service.getContact("01");
		assertNull(removedContact, "Contact successfully removed.");
	}
	

}
