
package contacts;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.Test;
import contacts.Contact;

class ContactTest {
	// Testing to ensure contact can be created as expected with valid input for parameters
	@Test
	void testValidParams() {
		String validContactID = "098765";
		String validFirstName = "James";
		String validLastName = "Holden";
		String validPhone = "1234567890";
		String validAddress = "123 Roci Dr";
		// Create contact with entered data
		Contact contact = new Contact(validContactID, validFirstName, validLastName, validPhone, validAddress);
		// Check that each parameter can be gathered as expected
		assertTrue(contact.getFirstName().equals(validFirstName));
		assertTrue(contact.getLastName().equals(validLastName));
		assertTrue(contact.getContactID().equals(validContactID));
		assertTrue(contact.getPhone().equals(validPhone));
		assertTrue(contact.getAddress().equals(validAddress));
	}
	// Testing the creation of a Contact object
	@Test
	void testCreateContact() {
		String validContactID = "098765";
		String validFirstName = "James";
		String validLastName = "Holden";
		String validPhone = "1234567890";
		String validAddress = "123 Roci Dr";
		// Create contact with input data
		Contact contact = new Contact(validContactID, validFirstName, validLastName, validPhone, validAddress);
		// Check that contact is not null
		assertNotNull(contact, "Contact object should not be null");
	}
	// Testing Contact ID being too long
	@Test
	void testInvalidContactID() {
		String invalidContactID = "09876543210"; // Eleven characters long
		String validFirstName = "James";
		String validLastName = "Holden";
		String validPhone = "1234567890";
		String validAddress = "123 Roci Dr";
		// Throw error when contact ID is too long
		assertThrows(IllegalArgumentException.class, () -> new Contact(invalidContactID, validFirstName, validLastName, validPhone, validAddress));
	}
	// Testing no input of Contact ID
	@Test
	void testContactIDNull() {
		String validFirstName = "John";
		String validLastName = "Doe";
		String validPhone = "1234567890";
		String validAddress = "123 Main St";
		// Throw error if contact ID is null
		assertThrows(IllegalArgumentException.class, () -> new Contact(null, validFirstName, validLastName, validPhone, validAddress));
	}
	// Testing for a first name that is too long
	@Test
	void testInvalidFirstName() {
		String validContactID = "0987654321"; 
		String invalidFirstName = "JamesHoldenn"; // Eleven characters long
		String validLastName = "Holden";
		String validPhone = "1234567890";
		String validAddress = "123 Roci Dr";
		// Throw error if first name is too long
		assertThrows(IllegalArgumentException.class, () -> new Contact(validContactID, invalidFirstName, validLastName, validPhone, validAddress));
	}
	
	@Test
	// First Name variable is not included, tested as null
	void testFirstNameNull() {
		String validContactID = "0987654321"; 
		String validLastName = "Doe";
		String validPhone = "1234567890";
		String validAddress = "123 Main St";
		// Throw error if first name is null
		assertThrows(IllegalArgumentException.class, () -> new Contact(validContactID, null, validLastName, validPhone, validAddress));
	}
	// Testing input of too long of last name
	@Test
	void testInvalidLastName() {
		String validContactID = "0987654321"; 
		String validFirstName = "James"; 
		String invalidLastName = "HoldenJamess"; // Eleven characters long
		String validPhone = "1234567890";
		String validAddress = "123 Roci Dr";
				
		assertThrows(IllegalArgumentException.class, () -> new Contact(validContactID, validFirstName, invalidLastName, validPhone, validAddress));
	}
	// Testing no input of last name
	@Test
	void testLastNameNull() {
		String validContactID = "0987654321"; 
		String validFirstName = "JamesHolden"; 
		String validPhone = "1234567890";
		String validAddress = "123 Roci Dr";
		// Throw error if last name is null
		assertThrows(IllegalArgumentException.class, () -> new Contact(validContactID, validFirstName, null, validPhone, validAddress));
	}
	// Testing input of too short a phone number
	@Test
	void testInvalidPhoneLength() {
		String validContactID = "0987654321"; 
		String validFirstName = "James"; 
		String validLastName = "Holden"; 
		String invalidPhone = "12345678"; // Eight characters long
		String validAddress = "123 Roci Dr";
		// Throw error is number is too short	
		assertThrows(IllegalArgumentException.class, () -> new Contact(validContactID, validFirstName, validLastName, invalidPhone, validAddress));
	}
	// Testing input of a letter in phone number field
	@Test
	void testInvalidPhoneIllegalChar() {
		String validContactID = "0987654321"; 
		String validFirstName = "James"; 
		String validLastName = "Holden"; 
		String invalidPhone = "12345678s0"; // Uses a letter in phone number
		String validAddress = "123 Roci Dr";
		// Throw error if phone number contains anything other than digits
		assertThrows(IllegalArgumentException.class, () -> new Contact(validContactID, validFirstName, validLastName, invalidPhone, validAddress));
	}
	// Testing lack of input for phone number
	@Test
	void testPhoneNull() {
		String validContactID = "0987654321"; 
		String validFirstName = "James"; 
		String validLastName = "Holden"; 
		String validAddress = "123 Roci Dr";
		// Throw error if phone number is null	
		assertThrows(IllegalArgumentException.class, () -> new Contact(validContactID, validFirstName, validLastName, null, validAddress));
	}
	// Testing for an address that is too long
	@Test
	void testInvalidAddress() {
		String validContactID = "0987654321"; 
		String validFirstName = "James"; 
		String validLastName = "Holden"; 
		String validPhone = "12345678s0"; 
		String invalidAddress = "123 Roci Dr, Earth, Not Mars Or The Belter Station"; // Address is greater than 30 characters
		// Throw error if address is too long
		assertThrows(IllegalArgumentException.class, () -> new Contact(validContactID, validFirstName, validLastName, validPhone, invalidAddress));
	}
	// Testing lack of input for address
	@Test
	void testAddressNull() {
		String validContactID = "0987654321"; 
		String validFirstName = "James"; 
		String validLastName = "Holden"; 
		String validPhone = "12345678s0"; 
		// Throw error if address is too long
		assertThrows(IllegalArgumentException.class, () -> new Contact(validContactID, validFirstName, validLastName, validPhone, null));
	}
	
}
	
	