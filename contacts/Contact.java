package contacts;

// Contact class with required fields
public class Contact {
	// Declare private fields  
    private String contactID; 
    private String firstName;
    private String lastName;
    private String phone;
    private String address;

    // Public Contact object with private fields declared 
    public Contact(String contactID, String firstName, String lastName, String phone, String address) {
    	if (contactID == null || contactID.length() > 10) {
    		throw new IllegalArgumentException("ID is not Valid");
    	}
    	// Set current fields of Contact object to validated input
        this.contactID = validateContactID(contactID);
        this.firstName = validateFirstName(firstName);
        this.lastName = validateLastName(lastName);
        this.phone = validatePhone(phone);
        this.address = validateAddress(address);
    }

    // === Getters === //
    // Getter for contactID
    public String getContactID() {
        return contactID;
    }
    // Getter for firstName
    public String getFirstName() {
        return firstName;
    }
    // Getter for lastName
    public String getLastName() {
        return lastName;
    }
    // Getter for phone
    public String getPhone() {
        return phone;
    }
    // Getter for address
    public String getAddress() {
        return address;
    }
    
    // === Setters === // 
    // Setter for firstName
    public void setFirstName(String firstName) {
    	// Call validate function, pass firstName, then set to this.firstName if valid)
        this.firstName = validateFirstName(firstName);
    }
    // Setter for lastName
    public void setLastName(String lastName) {
    	// Call validate function, pass lastName, then set to this.lastName if valid)
        this.lastName = validateLastName(lastName);
    }
    // Setter for phone
    public void setPhone(String phone) {
    	// Call validate function, pass phone, then set to this.phone if valid)
        this.phone = validatePhone(phone);
    }
    // Setter for address
    public void setAddress(String address) {
    	// Call validate function, pass address, then set to this.address if valid)
        this.address = validateAddress(address);
    }
    
    // === Validation Methods === // 
    // Validate contactID
    private String validateContactID(String contactID) {
    	if (contactID == null || contactID.length() > 10) {
    		throw new IllegalArgumentException("ID is not Valid, please ensure it is not empty or greater than ten characters");
    	}
    	return contactID;
    }
    // Validate firstName 
    private String validateFirstName(String firstName) {
    	// Check if null or greater than 10 characters, throw error if so
    	if (firstName == null || firstName.length() > 10) {
    		throw new IllegalArgumentException("First Name cannot be empty or greater than ten characters");
    	}
    	return firstName;
    }
    // Validate lastName:
    private String validateLastName(String lastName) {
    	// Check if null or greater than 10 characters, throw error if so
    	if (lastName == null || lastName.length() > 10) {
    		throw new IllegalArgumentException("Last Name cannot be empty or greater than ten characters");
    	}
    	return lastName;
    }
    private String validatePhone(String phone) {
    	// Check if null or greater than 10 characters, throw error if so
    	if (phone == null || phone.length() != 10) {
    		throw new IllegalArgumentException("Phone number must be exactly ten digits");
    	}
    	// Begin loop to iterate through phone number
    	for (char c : phone.toCharArray()) {
    		// If current character is not a digit, throw an error
    		if(!Character.isDigit(c)) {
    			throw new IllegalArgumentException("Phone number may only contain digits");
    		}
    	}
    	return phone;
    }
    // Validate address
    private String validateAddress(String address) {
    	// Check if null or greater than 30 characters, throw error if so
    	if (address == null || address.length() > 30) {
    		throw new IllegalArgumentException("Address cannot be empty or greater than thirty characters");
    	}
    	return address;
    }
}


