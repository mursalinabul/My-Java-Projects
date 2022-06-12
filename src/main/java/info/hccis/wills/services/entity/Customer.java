package info.hccis.wills.services.entity;

import info.hccis.util.CisUtility;

/**
 * Represents a customer
 *
 * @author bjmac
 * @since 8-Jun-2021
 */
public class Customer {

    private String firstName;
    private String lastName;
    private int customerType;

    public static final int TYPE_PREFERRED = 1;
    public static final int TYPE_SENIOR = 2;
    public static final double DISCOUNT_PREFERRED = 0.10;
    public static final double DISCOUNT_SENIOR = 0.15;

    public Customer() {
    }

    /**
     * Constructor that accepts first and last name as one string
     *
     * @since 20210608
     * @author BJM
     */
    public Customer(String name) {
        setFirstAndLastName(name);
    }

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Customer(String firstName, String lastName, int customerType) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.customerType = customerType;
    }

    /**
     * Method to return the discount rate appropriate for this customer based on
     * the type.
     *
     * @since 20210608
     * @author BJM
     */
    public double getDisountRate() {
        double discount = 0;
        switch (customerType) {
            case TYPE_PREFERRED:
                discount = DISCOUNT_PREFERRED;
                break;
            case TYPE_SENIOR:
                discount = DISCOUNT_SENIOR;
                break;
        }
        return discount;
    }

    /**
     * Get the description based on the customer type
     *
     * @since 20210608
     * @author BJM
     */
    public String getCustomerTypeDesctipion() {
        String description = "Regular";
        switch (customerType) {
            case TYPE_PREFERRED:
                description = "Preferred";
                break;
            case TYPE_SENIOR:
                description = "Senior";
                break;
        }
        return description;
    }

    /**
     * Get the first and last name out of the one string.Note that it is
     * expected to have exactly two parts. Note also that it is called from the
     * constructor which is why it is set to final (We'll get to this in
     * inheritance. It will work without final but give a warning.
     *
     * @param name Full name (first and last separated by space)
     * @since 20210608
     * @author BJM
     */
    public final void setFirstAndLastName(String name) {
        String[] parts = name.split(" ");
        if (parts.length >= 2) {
            firstName = parts[0];
            lastName = parts[1];
        }
    }

    public void getInformation() {
        this.firstName = CisUtility.getInputString("First Name?");
        this.lastName = CisUtility.getInputString("Last Name?");
        this.customerType = CisUtility.getInputInt("Customer Type (0=Regular 1=Preferred 2=Senior");

        while (customerType != 0 && customerType != 1 && customerType != 2) {
            customerType = CisUtility.getInputInt("Error - Please try again.\nCustomer type (0=regular 1=preferred 2=senior)?");
        }

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getCustomerType() {
        return customerType;
    }

    public void setCustomerType(int customerType) {
        this.customerType = customerType;
    }

    public void display() {
        CisUtility.display(this.toString());
    }

    public String toString() {
        String output = "Name: " + firstName + " " + lastName + " Customer Type: " + getCustomerTypeDesctipion();
        return output;
    }
}
